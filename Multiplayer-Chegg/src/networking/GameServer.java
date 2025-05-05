package networking;

import _main.panel.GamePanel;

import java.io.*;
import java.net.Socket;

public class GameServer {

    GamePanel gp;

    Socket socket;

    InputStream in;
    OutputStream out;

    ConnectionThread connectionThread;

    public GameServer(GamePanel gp) {
        this.gp = gp;
    }



    public void startConnecting() {

        // creates a thread that waits for a connection
        // if another player connects, it initializes the socket and starts the game
        connectionThread = new ConnectionThread(gp, this);
        connectionThread.start();
    }

    public void stopConnecting() {

        connectionThread.stopConnecting();
        connectionThread = null;
    }



    public void initConnection(Socket socket ) throws IOException {

        this.socket = socket;
        this.in = socket.getInputStream();
        this.out = socket.getOutputStream();
        connectionThread = null;

        gp.gameM.startGame();
    }

}
