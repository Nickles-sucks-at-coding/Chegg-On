package game;

import _main.panel.GamePanel;

public class GameManager {

    GamePanel gp;

    public GameManager(GamePanel gp) {
        this.gp = gp;
    }

    public void startGame() {

        gp.inGame = true;
    }
}
