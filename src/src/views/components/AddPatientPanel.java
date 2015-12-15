package views.components;

import models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatientPanel extends JPanel implements ActionListener {

    private static final int PADDING = 20;
    private final int TEXTBOX_SIZE = 300;
    private JButton submit;
    private JComboBox titleChoice;
    private JTextArea firstNameInput;
    private JTextArea surnameInput;
    private JTextArea dateInput;
    private JTextArea phoneInput;
    private JTextArea houseNumberInput;
    private JTextArea streetInput;
    private JTextArea districtInput;
    private JTextArea cityInput;
    private JTextArea postCodeInput;
    private JDialog parent;

    public AddPatientPanel(JDialog parent){


        super();
        this.parent = parent;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel titleLabel = new JLabel("Title: ");
        titleChoice = new JComboBox(Title.values());
        titleChoice.setAlignmentX(LEFT_ALIGNMENT);
        titleChoice.addActionListener(this);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameInput = new InputArea("", TEXTBOX_SIZE);

        JLabel surnameLabel = new JLabel("Surname: ");
        surnameInput = new InputArea("", TEXTBOX_SIZE);

        JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
        dateInput = new InputArea("", TEXTBOX_SIZE);

        JLabel phoneNumberLabel = new JLabel("Phone: ");
        phoneInput = new InputArea("", TEXTBOX_SIZE);

        JLabel houseNumberLabel = new JLabel("House Number: ");
        houseNumberInput = new InputArea("", TEXTBOX_SIZE);

        JLabel streetNameLabel = new JLabel("Street: ");
        streetInput = new InputArea("", TEXTBOX_SIZE);

        JLabel districtNameLabel = new JLabel("District: ");
        districtInput = new InputArea("", TEXTBOX_SIZE);

        JLabel cityNameLabel = new JLabel("City: ");
        cityInput = new InputArea("", TEXTBOX_SIZE);

        JLabel postCodeLabel = new JLabel("Post Code: ");
        postCodeInput = new InputArea("", TEXTBOX_SIZE);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setAlignmentX(LEFT_ALIGNMENT);

        add(titleLabel);
        add(titleChoice);
        add(firstNameLabel);
        add(firstNameInput);
        add(surnameLabel);
        add(surnameInput);
        add(dateOfBirthLabel);
        add(dateInput);
        add(phoneNumberLabel);
        add(phoneInput);
        add(houseNumberLabel);
        add(houseNumberInput);
        add(streetNameLabel);
        add(streetInput);
        add(districtNameLabel);
        add(districtInput);
        add(cityNameLabel);
        add(cityInput);
        add(postCodeLabel);
        add(postCodeInput);
        add(Box.createRigidArea(new Dimension(0, PADDING)));
        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == submit){

            Patient newPatient = new Patient((Title)titleChoice.getSelectedItem(),
                                            firstNameInput.getText(),
                                            surnameInput.getText(),
                                            new Date(dateInput.getText()),
                                            phoneInput.getText(),
                                            new Address(Integer.valueOf(houseNumberInput.getText()),
                                                        streetInput.getText(),
                                                        districtInput.getText(),
                                                        cityInput.getText(),
                                                        postCodeInput.getText()));

//            System.out.println(newPatient.toString());
            Patients.add(newPatient);

            this.parent.dispose();

        }

    }

}
