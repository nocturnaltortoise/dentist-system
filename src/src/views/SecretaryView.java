package views;

import views.components.SecretaryMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SecretaryView extends JFrame implements ActionListener{

    private JButton advanceWeekButton;
    private CalendarView secretaryCalendar;

    public SecretaryView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        secretaryCalendar = new CalendarView(true, getMonday(LocalDate.now()));
        contentPane.add(secretaryCalendar);
        setJMenuBar(new SecretaryMenu(this));

        advanceWeekButton = new JButton(">");
        advanceWeekButton.addActionListener(this);
        secretaryCalendar.addTabbedPane();
        add(advanceWeekButton,BorderLayout.PAGE_START);
    }

    private LocalDate getMonday(LocalDate currentDate){

        while(currentDate.getDayOfWeek() != DayOfWeek.MONDAY){
            currentDate = currentDate.minusDays(1);
        }

        return currentDate;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == advanceWeekButton){
            this.remove(secretaryCalendar);
            System.out.println("Should have done something");
//            secretaryCalendar = new CalendarView(true,secretaryCalendar.getStartOfWeek().plusDays(7));
//            this.add(secretaryCalendar);
        }

    }

}
