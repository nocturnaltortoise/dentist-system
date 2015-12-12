package views;

import views.components.SecretaryMenu;

import javax.swing.*;
import java.awt.*;

public class SecretaryView extends JFrame{

    public SecretaryView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        CalendarView secretaryCalendar = new CalendarView(true);
        contentPane.add(secretaryCalendar);
        setJMenuBar(new SecretaryMenu(this));
//        contentPane.add(new views.components.SecretaryMenu(),BorderLayout.NORTH);
        secretaryCalendar.addTabbedPane();

    }

    //TODO: add similar view for partners
}
