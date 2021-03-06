package views.components;

import models.Appointment;
import models.Date;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DayPanel extends JPanel {

    private Date date;
    private ArrayList<Appointment> appointments;

    public DayPanel(Date date, ArrayList<Appointment> appointments, boolean sec) {
        super();
        this.date = date;
        this.appointments = appointments;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
        setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        JLabel contents = new JLabel(date.getDate().getDayOfWeek().toString() + " " + date.getDate().getDayOfMonth());
        contents.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(contents);

        displayAppointments(sec);
    }

    private void displayAppointments(boolean sec) {
        for (Appointment app : appointments) {
            AppointmentPanel b = new AppointmentPanel(app, sec);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(b);
            add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

}
