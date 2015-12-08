import javax.swing.*;
import java.awt.*;
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

        ImageIcon icon = ResourceHandler.createImageIcon("res/tab_icon.png");

        LocalDate currentDate = LocalDate.now();

        CalendarPanel dentistTab = new CalendarPanel(currentDate);
        tabbedPane.addTab("Dentist", icon, dentistTab);

        CalendarPanel hygienistTab = new CalendarPanel(currentDate);
        tabbedPane.addTab("Hygienist", icon, hygienistTab);

        tabbedPane.setBackground(CustomColor.GREY);
        tabbedPane.setForeground(CustomColor.LIGHT_GREY);

        //TODO: Get icons displayed above text in tabs.

        CalendarGrid calendarGridDentist = new CalendarGrid(1, 7);
        CalendarGrid calendarGridHygienist = new CalendarGrid(1, 7);

        calendarGridDentist.displayColumns(PartnerType.DENTIST, currentDate);
        calendarGridHygienist.displayColumns(PartnerType.HYGIENIST, currentDate);

        dentistTab.add(calendarGridDentist, BorderLayout.CENTER);
        hygienistTab.add(calendarGridHygienist, BorderLayout.CENTER);
        contentPane.add(tabbedPane);

        setVisible(true);
    }

}
