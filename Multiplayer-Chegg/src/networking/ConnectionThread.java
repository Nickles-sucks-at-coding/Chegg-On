package networking;

import _main.panel.GamePanel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import static _main.setting.Settings.GAME_PORT;

public class ConnectionThread extends Thread {

    GamePanel gp;
    GameServer server;

    ServerSocket serverSocket;

    boolean stopped = false;

    public ConnectionThread(GamePanel gp, GameServer server) {

        this.gp = gp;
        this.server = server;

        try {
            serverSocket = new ServerSocket(GAME_PORT);
            serverSocket.setSoTimeout(50);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        boolean playerConnected = false;

        while (!playerConnected && !stopped) {

            try {
                // will wait at this point until another player is connected
                Socket socket = serverSocket.accept();

                System.out.println(serverSocket);

                System.out.println("accpeted");

                if (gp.inGame)
                    return;

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.println("wait let me check if the join id is right");

                if (!checkJoinID(in))
                    continue;

                System.out.println("it was right, i am far right");

                System.out.println("i am gonna init, yoo");
                // initialize connection and give the socket to the server
                server.initConnection(socket);
                System.out.println("i inited like tomy innit fr fr");
                playerConnected = true;

            } catch (IOException e) {
                continue;
            }
        }

        System.out.println("server was stopped!");
    }

    public void stopConnecting() {

        stopped = true;
    }



    boolean checkJoinID(BufferedReader in) throws IOException {

        String line = null;
        while (line == null) {

            if (in.ready())
                line = in.readLine();
        }

        System.out.println("gotten join line:   " + line);

        if (!line.startsWith("join "))
            return false;

        String joinIdString  = line.substring(5);
        short receivedJoinID = Short.parseShort(joinIdString);

        System.out.println("gotten join id:   " + receivedJoinID);
        System.out.println("real join id:   " + gp.currentJoinID);
        System.out.println("valid:   " + (receivedJoinID == gp.currentJoinID));

        return receivedJoinID == gp.currentJoinID;
    }

}
