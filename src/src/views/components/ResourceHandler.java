package views.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceHandler {

    public static Font createFont(String path) {
        try {
            Font f = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
            return f;
        } catch (IOException|FontFormatException e) {
            System.err.println("Can't find a file at: " + path);
            return null;
        }
    }

    public static ImageIcon createImageIcon(String path) {
        try {
            File filePath = new File(path);
            BufferedImage image = ImageIO.read(filePath);
            return new ImageIcon(image);
        } catch (IOException e) {
            System.err.println("Can't find a file at: " + path);
            return null;
        }
    }
}
