import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CalendarView extends JFrame{

    public CalendarView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        ImageIcon icon = createImageIcon("res/tab_icon.png");

        JPanel dentistTab = new JPanel();
        tabbedPane.addTab("Dentist", icon, dentistTab);

        JComponent hygienistTab = new JPanel();
        tabbedPane.addTab("Hygienist", icon, hygienistTab);

        //TODO: Get icons displayed above text in tabs.
        //TODO: Change foreground and background colours of tabs.

        contentPane.add(tabbedPane);

        setVisible(true);
    }

    private static ImageIcon createImageIcon(String path) {
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
