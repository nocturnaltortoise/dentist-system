package views;

import models.PartnerType;
import views.components.CalendarGrid;
import views.components.CalendarPanel;
import views.components.CustomColor;
import views.components.ResourceHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class CalendarView extends JPanel{

    private JTabbedPane tabbedPane = new JTabbedPane();
    private LocalDate startOfWeek;

    public LocalDate getStartOfWeek(){
        return this.startOfWeek;
    }

    public CalendarView(boolean sec, LocalDate startOfWeek){
        //This has to be done before a JTabbedPane is created

        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        ImageIcon icon = ResourceHandler.createImageIcon("res/tab_icon.png");

        this.startOfWeek = startOfWeek;

        CalendarPanel dentistTab = new CalendarPanel(startOfWeek);
        tabbedPane.addTab("Dentist", icon, dentistTab);

        CalendarPanel hygienistTab = new CalendarPanel(startOfWeek);
        tabbedPane.addTab("Hygienist", icon, hygienistTab);

        tabbedPane.setBackground(CustomColor.GREY);
        tabbedPane.setForeground(CustomColor.LIGHT_GREY);

        //TODO: Get icons displayed above text in tabs.

        CalendarGrid calendarGridDentist = new CalendarGrid(1, 7, sec);
        CalendarGrid calendarGridHygienist = new CalendarGrid(1, 7, sec);


        calendarGridDentist.displayColumns(PartnerType.DENTIST, startOfWeek);
        calendarGridHygienist.displayColumns(PartnerType.HYGIENIST, startOfWeek);

        dentistTab.add(calendarGridDentist, BorderLayout.CENTER);
        hygienistTab.add(calendarGridHygienist, BorderLayout.CENTER);

    }

    public void addTabbedPane(){
        JFrame window = (JFrame) SwingUtilities.windowForComponent(this);
        window.add(tabbedPane, BorderLayout.CENTER);
    }

}
