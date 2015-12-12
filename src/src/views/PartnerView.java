package views;

import views.components.PartnerMenu;

import javax.swing.*;
import java.awt.*;

public class PartnerView extends JFrame {

    public PartnerView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        CalendarView partnerCalendar = new CalendarView(false);
        contentPane.add(partnerCalendar);
        setJMenuBar(new PartnerMenu());
        partnerCalendar.addTabbedPane();
    }

}
