package views;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class PartnerView extends JFrame {

    public PartnerView(){
        setSize(1280,720);
        setTitle("Calendar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        UIManager.put("TabbedPane.selected", new Color(93,93,93));
        CalendarView partnerCalendar = new CalendarView(false, getMonday(LocalDate.now()));
        contentPane.add(partnerCalendar);
        partnerCalendar.addTabbedPane();
    }

    private LocalDate getMonday(LocalDate currentDate){

        while(currentDate.getDayOfWeek() != DayOfWeek.MONDAY){
            currentDate = currentDate.minusDays(1);
        }

        return currentDate;
    }

}
