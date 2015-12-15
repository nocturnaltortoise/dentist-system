package views.components;

import models.Patient;
import models.Patients;
import views.ProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientButton extends JButton implements ActionListener{

    private Patient patient;
    private boolean sec;

    public PatientButton(Patient patient, boolean sec) {
        super("");
        this.patient = patient;
        this.sec = sec;
        String name = patient.getName().toString();
        setText(name);
        //setBounds(getX(), getY(), panel.getWidth(), panel.getHeight());

        //Button settings
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        patient = Patients.getAll(patient.getId());
        new ProfileView(patient, sec);
    }


}
