package _main;

import _main.panel.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static _main.setting.Settings.TITLE;

public class Main {

    public static void main(String[] args) {

        // create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set title and if it is resizable
        window.setTitle(TITLE);
        window.setResizable(false);

        // create the GamePanel and add it to the window
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        // set window icon
        try {
            BufferedImage icon = ImageIO.read(new File("res/icon.png"));
            window.setIconImage(icon);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // make window visible and set it the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // start game
        gp.startProgramThread();
    }
}