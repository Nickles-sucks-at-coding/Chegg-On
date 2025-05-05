package menu.buttons;

import _main.panel.GamePanel;
import networking.GameServer;

import java.awt.image.BufferedImage;

import static _main.setting.ResourceSettings.OPEN_BUTTON_OFF_IMG;
import static _main.setting.ResourceSettings.OPEN_BUTTON_ON_IMG;

public class OpenButton extends MenuButton {

    public OpenButton(GamePanel gp, BufferedImage img, int x, int y, int width, int height) {
        super(gp, img, x, y, width, height);
    }

    @Override
    void onPressed() {

        gp.open = !gp.open;

        if (gp.open) {

            img = OPEN_BUTTON_ON_IMG;
            gp.server.startConnecting();
        } else {

            img = OPEN_BUTTON_OFF_IMG;
            gp.server.stopConnecting();
        }

    }
}
