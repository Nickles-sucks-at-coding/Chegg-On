package networking;

import _main.panel.GamePanel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static _main.setting.Settings.GAME_PORT;

public class ConnectionThread extends Thread {

    GamePanel gp;
    GameServer server;

    InputStream  in;
    OutputStream out;

    public ConnectionThread(GamePanel gp, GameServer server) {

        this.gp = gp;
        this.server = server;
    }

    @Override
    public void run() {

        boolean connectedCorrectly = false;

        while (!connectedCorrectly) {

            try (ServerSocket serverSocket = new ServerSocket(GAME_PORT)) {

                // will wait at this point until another player is connected
                Socket clientSocket = serverSocket.accept();

                if (gp.inGame)
                    return;

                in  = clientSocket.getInputStream();
                out = clientSocket.getOutputStream();

                if (!checkJoinID())
                    continue;

                server.in = in;
                server.out = out;

                connectedCorrectly = true;
                gp.gameM.startGame();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    boolean checkJoinID() throws IOException {

        List<Byte> receivedBytes = new ArrayList<>(2);

        while (receivedBytes.size() < 2) {

            int inByte = in.read();
            if (inByte != -1)
                receivedBytes.add((byte) (inByte - 128));
        }

        short b1 = (short) (receivedBytes.get(0) << 8);
        short b2 = receivedBytes.get(1);
        short receivedJoinID = (short) (b1 | b2);

        return receivedJoinID == gp.currentJoinID;
    }

}
