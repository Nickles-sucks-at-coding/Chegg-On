package _main.setting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ResourceSettings {

    // MENU IMAGES
    private static final String MENU_BG_FILEPATH = "res/menu/menu_background.png";

    private static final String COPY_BUTTON_FILEPATH = "res/menu/copy_button.png";
    private static final String JOIN_BUTTON_FILEPATH = "res/menu/join_button.png";

    private static final String OPEN_BUTTON_ON_FILEPATH  = "res/menu/open_button_on.png";
    private static final String OPEN_BUTTON_OFF_FILEPATH = "res/menu/open_button_off.png";

    public static final BufferedImage MENU_BG_IMG;
    public static final BufferedImage COPY_BUTTON_IMG;
    public static final BufferedImage JOIN_BUTTON_IMG;
    public static final BufferedImage OPEN_BUTTON_ON_IMG;
    public static final BufferedImage OPEN_BUTTON_OFF_IMG;

    static {
        try {

            MENU_BG_IMG = ImageIO.read(new File(MENU_BG_FILEPATH));

            COPY_BUTTON_IMG = ImageIO.read(new File(COPY_BUTTON_FILEPATH));
            JOIN_BUTTON_IMG = ImageIO.read(new File(JOIN_BUTTON_FILEPATH));

            OPEN_BUTTON_ON_IMG  = ImageIO.read(new File(OPEN_BUTTON_ON_FILEPATH));
            OPEN_BUTTON_OFF_IMG = ImageIO.read(new File(OPEN_BUTTON_OFF_FILEPATH));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
