package views.components;

import models.Appointment;
import models.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ResultPanel extends JPanel {

    private final int PADDING = 5;
    private final Dimension size = new Dimension(500, 50);
    private ArrayList<Appointment> appointmentList;

    public ResultPanel(ArrayList<Appointment> appointmentList) {
        super();
        this.appointmentList = appointmentList;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
//        setMinimumSize(size);
//        setMaximumSize(size);

        for(Appointment app : appointmentList){
            JLabel infoLabel = new JLabel(
                    app.getPatient().getName()
                            + " | " + app.getType()
                            + " | " + app.getStartTime() + " - " + app.getEndTime()
                            + " | " + app.getPartner().getName()
                            + " | " + app.getDate());
            add(infoLabel);
        }


//        patientList.forEach(patient -> infoLabel = new JLabel(patient.getName().toString()));




    }

}
