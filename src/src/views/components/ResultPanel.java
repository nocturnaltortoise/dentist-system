package views.components;

import models.Appointment;
import models.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ResultPanel extends JPanel {

    private final int PADDING = 5;
    private final Dimension size = new Dimension(500, 50);
    private Appointment app;
    private Patient p;

    public ResultPanel(Appointment app) {
        super();
        this.app = app;
        this.p = app.getPatient();
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        setMinimumSize(size);
        setMaximumSize(size);

        JLabel infoLabel = new JLabel(
                p.getName()
                + " | " + app.getType()
                + " | " + app.getStartTime() + " - " + app.getendTime()
                + " | " + app.getPartner().getName()
                + " | " + app.getDate());

        add(infoLabel);
    }

}
