package menu_ui.buttons;

import _main.panel.GamePanel;
import networking.GameClient;
import utils.join_code.JoinCodeManager;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Inet4Address;

import static utils.GeneralUtils.clipboard;

public class JoinButton extends MenuButton {

    public JoinButton(GamePanel gp, BufferedImage img, int x, int y, int width, int height) {
        super(gp, img, x, y, width, height);
    }

    @Override
    void onPressed() {

        try {
            String givenJoinCode = (String) clipboard.getData(DataFlavor.stringFlavor);

            byte[] givenServerAddress = JoinCodeManager.getOriginalIP(givenJoinCode);
            Inet4Address givenServerIP = (Inet4Address) Inet4Address.getByAddress(givenServerAddress);

            short givenJoinID = JoinCodeManager.getJoinID(givenJoinCode);

            gp.client = new GameClient(givenServerIP, givenJoinID);

        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
