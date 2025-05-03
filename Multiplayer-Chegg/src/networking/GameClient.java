package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Socket;

import static _main.setting.Settings.GAME_PORT;

public class GameClient {

    InputStream in;
    OutputStream out;

    public GameClient(Inet4Address serverIP, short joinID) {

        try {
            Socket socket = new Socket(serverIP, GAME_PORT);

            in = socket.getInputStream();
            out = socket.getOutputStream();

            byte b1 = (byte) (joinID >>> 8);
            byte b2 = (byte) joinID;

            out.write(b1);
            out.write(b2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
