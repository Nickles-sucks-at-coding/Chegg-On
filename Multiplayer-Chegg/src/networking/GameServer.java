package networking;

import _main.panel.GamePanel;

import java.io.*;

public class GameServer {

    InputStream in;
    OutputStream out;

    public GameServer(GamePanel gp) {

        ConnectionThread connectionThread = new ConnectionThread(gp, this);
        connectionThread.start();
    }



}
