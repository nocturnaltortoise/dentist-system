package views.components;

import models.AppointmentType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookPanel extends JPanel {

    private final int PADDING = 20;

    public BookPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel sTimeL = new JLabel("Start models.Time: ", SwingConstants.LEFT);
        JTextArea sTimeA = new InputArea("", 200);
        JLabel eTimeL = new JLabel("End models.Time: ", SwingConstants.LEFT);
        JTextArea eTimeA = new InputArea("", 200);
        JLabel patientL = new JLabel("models.Patient models.Name: ", SwingConstants.LEFT);
        JTextArea patientA = new InputArea("", 200);

        String[] partners = {"I need SQL 1", "I need SQL 2"};
        JLabel partnerL = new JLabel("models.Partner: ", SwingConstants.LEFT);
        JComboBox partnerA = new JComboBox(partners);
        partnerA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel typeL = new JLabel("models.Appointment Type: ", SwingConstants.LEFT);
        JComboBox typeA = new JComboBox(AppointmentType.getList());
        typeA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel dateL = new JLabel("models.Date of models.Appointment: ", SwingConstants.LEFT);
        JTextArea dateA = new InputArea("", 200);

        JButton submit = new JButton("Submit");
        submit.setAlignmentX(LEFT_ALIGNMENT);

        add(sTimeL);
        add(sTimeA);
        add(eTimeL);
        add(eTimeA);
        add(patientL);
        add(patientA);
        add(partnerL);
        add(partnerA);
        add(typeL);
        add(typeA);
        add(dateL);
        add(dateA);
        add(Box.createRigidArea(new Dimension(0, PADDING)));
        add(submit);
    }

}
