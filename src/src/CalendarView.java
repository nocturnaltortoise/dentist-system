import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.*;

public class CalendarView extends JFrame{

    public CalendarView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();

        //This has to be done before a JTabbedPane is created
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        ImageIcon icon = createImageIcon("res/tab_icon.png");

        JPanel dentistTab = new JPanel();
        tabbedPane.addTab("Dentist", icon, dentistTab);

        JComponent hygienistTab = new JPanel();
        tabbedPane.addTab("Hygienist", icon, hygienistTab);

        tabbedPane.setBackground(new Color(62,62,62));
        tabbedPane.setForeground(new Color(163,163,163));

        //TODO: Get icons displayed above text in tabs.

        dentistTab.setLayout(new BorderLayout());

        JLabel title = new JLabel("Month Name", SwingConstants.RIGHT);
        title.setOpaque(true);
        title.setBackground(new Color(37,90,108));
        title.setForeground(new Color(130,205,230));
        title.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        dentistTab.add(title, BorderLayout.NORTH);

        JPanel calendarGrid = new JPanel(new GridLayout(5,7));

        displayRows(calendarGrid, 2015, Month.DECEMBER, 1);

        dentistTab.add(calendarGrid, BorderLayout.CENTER);
        contentPane.add(tabbedPane);

        setVisible(true);
    }

    private void displayRows(JPanel calendarGrid, int year, Month month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 7; j++){ //TODO: Better way of displaying one month's dates.
                if(date.getMonth() == month){
                    JButton testButton = new JButton(date.plusDays(j).toString());
                    calendarGrid.add(testButton);
                }
            }
            date = date.plusWeeks(1);
        }
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
