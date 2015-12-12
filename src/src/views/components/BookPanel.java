package views.components;

import models.AppointmentType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookPanel extends JPanel {

    private final int PADDING = 20;
    private final int TEXTBOX_SIZE = 300;

    public BookPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel sTimeL = new JLabel("Start Time: ", SwingConstants.LEFT);
        JTextArea sTimeA = new InputArea("", TEXTBOX_SIZE);
        //JLabel eTimeL = new JLabel("End Time: ", SwingConstants.LEFT);
        //JTextArea eTimeA = new InputArea("", TEXTBOX_SIZE);
        JLabel patientL = new JLabel("Name: ", SwingConstants.LEFT);
        JTextArea patientA = new InputArea("", TEXTBOX_SIZE);

        String[] partners = {"I need SQL 1", "I need SQL 2"};
        JLabel partnerL = new JLabel("Partner: ", SwingConstants.LEFT);
        JComboBox partnerA = new JComboBox(partners);
        partnerA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel typeL = new JLabel("Appointment Type: ", SwingConstants.LEFT);
        JComboBox typeA = new JComboBox(AppointmentType.getList());
        typeA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel dateL = new JLabel("Date of Appointment: ", SwingConstants.LEFT);
        JTextArea dateA = new InputArea("", TEXTBOX_SIZE);
        //Appointment times are fixed by type, so no need to specify end time!

        //TODO: Upon submission, overlaps with other appointments and 9:00 - 17:00 need to be checked
        JButton submit = new JButton("Submit");
        submit.setAlignmentX(LEFT_ALIGNMENT);

        add(sTimeL);
        add(sTimeA);
        //add(eTimeL);
        //add(eTimeA);
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
