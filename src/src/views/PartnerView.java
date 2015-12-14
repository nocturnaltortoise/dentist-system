package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class PartnerView extends JFrame implements ActionListener {

    private JButton advanceWeekButton;
    private JButton previousWeekButton;
    private CalendarView partnerCalendar;
    private JPanel buttonPanel;

    public PartnerView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        partnerCalendar = new CalendarView(false, getMonday(LocalDate.now()));
        contentPane.add(partnerCalendar);

        buttonPanel = new JPanel();
        advanceWeekButton = new JButton(">");
        advanceWeekButton.addActionListener(this);
        previousWeekButton = new JButton("<");
        previousWeekButton.addActionListener(this);
        buttonPanel.add(previousWeekButton);
        buttonPanel.add(advanceWeekButton);
        add(buttonPanel, BorderLayout.PAGE_START);

        partnerCalendar.addTabbedPane();
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
            partnerCalendar.setStartOfWeek(partnerCalendar.getStartOfWeek().plusDays(7));
            rebuildCalendar();
        }else{
            partnerCalendar.setStartOfWeek(partnerCalendar.getStartOfWeek().minusDays(7));
            rebuildCalendar();
        }

    }

    public void rebuildCalendar(){
        this.getContentPane().removeAll();
        partnerCalendar = new CalendarView(false,partnerCalendar.getStartOfWeek());
        this.getContentPane().add(partnerCalendar);
        partnerCalendar.addTabbedPane();
        buttonPanel.add(previousWeekButton);
        buttonPanel.add(advanceWeekButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        revalidate();
        repaint();
    }

}
