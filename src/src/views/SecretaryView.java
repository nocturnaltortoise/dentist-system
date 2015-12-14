package views;

import views.components.SecretaryMenu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SecretaryView extends JFrame implements ActionListener{

    private JButton advanceWeekButton;
    private JButton previousWeekButton;
    private CalendarView secretaryCalendar;
    private JPanel buttonPanel;

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

        buttonPanel = new JPanel();
        advanceWeekButton = new JButton(">");
        advanceWeekButton.addActionListener(this);
        previousWeekButton = new JButton("<");
        previousWeekButton.addActionListener(this);
        buttonPanel.add(previousWeekButton);
        buttonPanel.add(advanceWeekButton);
        add(buttonPanel, BorderLayout.PAGE_START);

        secretaryCalendar.addTabbedPane();
//        add(advanceWeekButton,BorderLayout.PAGE_START);
//        add(previousWeekButton,)
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
            secretaryCalendar.setStartOfWeek(secretaryCalendar.getStartOfWeek().plusDays(7));
            rebuildCalendar();
        }else{
            secretaryCalendar.setStartOfWeek(secretaryCalendar.getStartOfWeek().minusDays(7));
            rebuildCalendar();
        }

    }

    public void rebuildCalendar(){
        this.getContentPane().removeAll();
        secretaryCalendar = new CalendarView(true,secretaryCalendar.getStartOfWeek());
        this.getContentPane().add(secretaryCalendar);
        secretaryCalendar.addTabbedPane();
        buttonPanel.add(previousWeekButton);
        buttonPanel.add(advanceWeekButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        revalidate();
        repaint();
    }

}
