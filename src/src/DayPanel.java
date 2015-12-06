import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by George Baron on 06/12/2015.
 */
public class DayPanel extends JPanel {

    private Date date;
    private ArrayList<Appointment> appointments;

    public DayPanel(Date date, ArrayList<Appointment> appointments) {
        super();
        this.date = date;
        this.appointments = appointments;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
        setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        JLabel contents = new JLabel(date.getDate().getDayOfWeek().toString() + " " + date.getDate().getDayOfMonth());
        contents.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(contents);

        displayAppointments();
    }

    private void displayAppointments() {
        for(Appointment app : appointments) {
            AppointmentButton b = new AppointmentButton(app);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(b);
        }

    }

}
