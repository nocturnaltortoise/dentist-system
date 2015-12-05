import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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

        LocalDate currentDate = LocalDate.now();

        JLabel title = new JLabel(currentDate.getMonth().toString() + " " + currentDate.getYear(), SwingConstants.RIGHT);
        title.setOpaque(true);
        title.setBackground(new Color(37,90,108));
        title.setForeground(new Color(130,205,230));
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,30)); //adds padding to the title
        dentistTab.add(title, BorderLayout.NORTH);

        JPanel calendarGrid = new JPanel(new GridLayout(1,7));

        displayColumns(calendarGrid, currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());

        dentistTab.add(calendarGrid, BorderLayout.CENTER);
        contentPane.add(tabbedPane);

        setVisible(true);
    }

    private void displayColumns(JPanel calendarGrid, int year, Month month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        for(int j = 0; j < 7; j++){
            LocalDate currentDate = date.plusDays(j);
            JPanel dayPanel = new JPanel();
            dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.Y_AXIS));

            dayPanel.setBackground(new Color(255,255,255));
            dayPanel.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));

            JLabel contents = new JLabel(currentDate.getDayOfWeek().toString() + " " + currentDate.getDayOfMonth());
            contents.setAlignmentX(Component.CENTER_ALIGNMENT);
            dayPanel.add(contents);

            JButton appointmentsListButton = new JButton("Appointments");
            appointmentsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            dayPanel.add(appointmentsListButton);

            calendarGrid.add(dayPanel);
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
