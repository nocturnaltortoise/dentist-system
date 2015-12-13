package views.components;

import models.Appointment;

import javax.swing.*;

public class ProfileAppointmentPanel extends JPanel {

    public ProfileAppointmentPanel(Appointment app) {

        setBackground(CustomColor.LIGHT_GREY);
        JLabel info = new JLabel(app.getType() + " | " + app.getPartner().getName() + " | "
                                 + app.getStartTime() + " - " + app.getEndTime()
                                 + " " + app.getDate());
        add(info);
    }

}
