package views.components;

import models.*;
import views.SecretaryView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookPanel extends JPanel implements ActionListener {

    private final int PADDING = 20;
    private final int TEXTBOX_SIZE = 300;
    private JTextArea idInput;
    private JTextArea sTimeA;
    private JComboBox titleInput;
    private JTextArea firstNameInput;
    private JTextArea surnameInput;
    private JComboBox partnerA;
    private JComboBox typeA;
    private JTextArea dateA;
    private JButton submit;
    private BookDialog parent;

    public BookPanel(BookDialog parent) {
        super();

        this.parent = parent;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel sTimeL = new JLabel("Start Time: ", SwingConstants.LEFT);
        sTimeA = new InputArea("", TEXTBOX_SIZE);
        //JLabel eTimeL = new JLabel("End Time: ", SwingConstants.LEFT);
        //JTextArea eTimeA = new InputArea("", TEXTBOX_SIZE);
        JLabel titleLabel = new JLabel("Title: ", SwingConstants.LEFT);
        titleInput = new JComboBox(Title.values());
        titleInput.setAlignmentX(LEFT_ALIGNMENT);

        JLabel idLabel = new JLabel("Patient ID: ", SwingConstants.LEFT);
        idInput = new InputArea("", TEXTBOX_SIZE);

        JLabel firstNameLabel = new JLabel("First Name: ", SwingConstants.LEFT);
        firstNameInput = new InputArea("", TEXTBOX_SIZE);

        JLabel surnameLabel = new JLabel("Surname: ", SwingConstants.LEFT);
        surnameInput = new InputArea("", TEXTBOX_SIZE);

        JLabel partnerL = new JLabel("Partner: ", SwingConstants.LEFT);
        partnerA = new JComboBox(PartnerType.values());
        partnerA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel typeL = new JLabel("Appointment Type: ", SwingConstants.LEFT);
        typeA = new JComboBox(AppointmentType.getList());
        typeA.setAlignmentX(LEFT_ALIGNMENT);

        JLabel dateL = new JLabel("Date of Appointment: ", SwingConstants.LEFT);
        dateA = new InputArea("", TEXTBOX_SIZE);
        //Appointment times are fixed by type, so no need to specify end time!

        //TODO: Upon submission, overlaps with other appointments and 9:00 - 17:00 need to be checked
        submit = new JButton("Submit");
        submit.setAlignmentX(LEFT_ALIGNMENT);
        submit.addActionListener(this);

//        add(titleLabel);
//        add(titleInput);
//        add(firstNameLabel);
//        add(firstNameInput);
//        add(surnameLabel);
//        add(surnameInput);
        add(idLabel);
        add(idInput);
        add(sTimeL);
        add(sTimeA);
        //add(eTimeL);
        //add(eTimeA);
        add(partnerL);
        add(partnerA);
        add(typeL);
        add(typeA);
        add(dateL);
        add(dateA);
        add(Box.createRigidArea(new Dimension(0, PADDING)));
        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == submit){
            Time startTime = new Time(sTimeA.getText());
            long appLength = AppointmentType.getLength(typeA.getSelectedItem().toString());
            Time endTime = startTime.plusMinutes(appLength);
            Patient appPatient = Patients.getAll(Integer.valueOf(idInput.getText()));
            Partner appPartner = Partners.getPartnerFromType(partnerA.getSelectedItem().toString());
            AppointmentType appType = AppointmentType.getAppointmentType(typeA.getSelectedItem().toString());
            Date appDate = new Date(dateA.getText());

            Appointment newAppointment = new Appointment(startTime, endTime, appPatient, appPartner, appType, appDate);

            System.out.println(newAppointment.toString());

            Appointments.add(newAppointment);

            SecretaryView currentView = (SecretaryView)SwingUtilities.getRoot(this).getParent();
            currentView.rebuildCalendar();
            parent.dispose();
        }
    }

}
