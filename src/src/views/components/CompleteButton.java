package views.components;

import models.Appointment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteButton extends JButton implements ActionListener {

    private Appointment app;

    public CompleteButton(Appointment app) {
        super("Complete");

        this.app = app;
        //Button settings
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        int button = JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog(this, "Mark this appointment as complete?", "Complete", button);
        if(answer == JOptionPane.YES_OPTION) {
            //Cancel
            new ConfirmVisitDialog((JFrame)SwingUtilities.getRoot(this), this.app, this);
            //this.setEnabled(false);
        }
    }
}
