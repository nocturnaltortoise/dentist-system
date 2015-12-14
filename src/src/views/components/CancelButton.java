package views.components;

import models.Appointment;
import models.Appointments;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButton extends JButton implements ActionListener {

    private String name;
    private Appointment app;

    public CancelButton(String s, Appointment app) {
        super("Cancel");
        this.app = app;
        name = s;

        //Button settings
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        int button = JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog(this, "Cancel appointment for " + name + "?", "Cancel", button);
        if(answer == JOptionPane.YES_OPTION) {
            Appointments.delete(app);
        }
    }

}
