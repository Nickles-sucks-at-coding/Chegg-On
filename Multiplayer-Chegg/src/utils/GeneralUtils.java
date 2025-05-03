package utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.util.Random;

public class GeneralUtils {

    // random number generator
    public static final Random random = new Random();

    // user's clipboard
    public static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
}
