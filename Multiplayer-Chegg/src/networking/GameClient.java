package networking;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;

import static _main.setting.Settings.GAME_PORT;

public class GameClient {

    BufferedReader in;
    BufferedWriter out;

    public GameClient(Inet4Address serverIP, short joinID) {

        try {
            Socket socket = new Socket(serverIP, GAME_PORT);

            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("sent join id:   " + joinID);

            String joinIdString = Short.toString(joinID);
            out.write("join " + joinIdString);
            out.newLine();
            out.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
