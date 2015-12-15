package views.components;

import models.Patient;
import models.Patients;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class PatientSearchPanel extends JPanel {

    private final int PADDING = 10;
    private ArrayList<Patient> patients;

    public PatientSearchPanel (ArrayList<Patient> p) {

        super();
        this.patients = p;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        //System.out.println(patients);

    }

}
