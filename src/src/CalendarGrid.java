import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class CalendarGrid extends JPanel {

    private final int DAYS_IN_WEEK = 7;
    private boolean sec;

    public CalendarGrid(int rows, int columns, boolean sec) {
        super(new GridLayout(rows, columns));
        this.sec = sec;
    }

    public void displayColumns(PartnerType p, LocalDate d){
        Date date = new Date(d);
        for(int j = 0; j < DAYS_IN_WEEK; j++){
            Date currentDate = new Date(date.getDate().plusDays(j));
            DayPanel dayPanel = new DayPanel(currentDate, getAppointments(currentDate, p), sec);

            add(dayPanel);
        }
    }

    private ArrayList<Appointment> getAppointments(Date day, PartnerType p) {
        //Assumes already sorted (done in SQL!)
        // TODO: Write SQL nonsense instead of using test data
        ArrayList<Appointment> appointments = new ArrayList(Arrays.asList(TestAppointments.appointments));
        ArrayList<Appointment> temp = new ArrayList<>();
        for(Appointment a : appointments){
            if(a.getDate().equals(day) && p.equals(a.getPartner().getPartnerType())){
                temp.add(a);
            }
        }
        return temp;
    }
}

