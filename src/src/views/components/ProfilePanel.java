package views.components;

import models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ProfilePanel extends JPanel {

    private final int PADDING = 20;

    public ProfilePanel(Patient p, boolean sec) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setBackground(CustomColor.DARK_GREY);

        ImageIcon icon = ResourceHandler.createImageIcon("res/profile_icon.png");
        JLabel image = new JLabel(icon, SwingConstants.CENTER);
        image.setAlignmentX(CENTER_ALIGNMENT);
        image.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        JLabel nameLabel = setLabel(p.getName().toString(), Color.WHITE, 36);
        JLabel dobLabel = setLabel(p.getDateOfBirth().toString(), CustomColor.LIGHT_GREY, 30);
        JLabel pLabel = setLabel(p.getPhone(), Color.WHITE, 24);
        JLabel addLabel = setLabel(p.getAddress().toString(), CustomColor.LIGHT_GREY, 24, false);
        JPanel appointments = createAppointmentList(p.getId());

        ArrayList<Appointment> appointmentsList = Appointments.getAll(p.getId());

        JPanel treatments = null;
        ArrayList<Treatment> treatmentsList = new ArrayList<>();
        for(Appointment app : appointmentsList){
            for(Treatment treatment : Treatments.getAll(app)){
                treatmentsList.add(treatment);
            }
            treatments = createTreatmentList(app);
        }

        double totalCost = 0;
        for(Treatment treatment : treatmentsList){
            totalCost += treatment.getType().getCost();
        }
        treatments.setLayout(new BoxLayout(treatments, BoxLayout.PAGE_AXIS));

        JLabel treatmentTotalCost = setLabel("£" + totalCost, Color.WHITE, 24);

        add(image);
        add(nameLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(dobLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(pLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(addLabel);
        if (sec) {
            JLabel healthcarePlanLabel = setLabel("Healthcare Plan: ", Color.WHITE, 24);
            JComboBox<HealthcarePlan> healthcarePlanInput = new JComboBox<>(HealthcarePlan.values());
            healthcarePlanInput.setAlignmentX(CENTER_ALIGNMENT);
            add(healthcarePlanLabel);
            add(healthcarePlanInput);
        }
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(appointments);
        add(treatmentTotalCost);
        add(treatments);

    }

//    ArrayList<Appointment> appList = Appointments.getAll(patient.patientId);
//
//    for(Appointment app: appList){
//          Treatments.getAll(app);
//    }

    private JPanel createTreatmentList(Appointment app) {
        ArrayList<Treatment> tList = Treatments.getAll(app);
        JPanel temp = new JPanel();
        temp.setBackground(CustomColor.DARK_GREY);
        tList.forEach(treatment -> temp.add(new ProfileTreatmentPanel(treatment)));
        //System.out.println(treatment.toString())
        //
        return temp;
    }

    private JPanel createAppointmentList(int id) {
        ArrayList<Appointment> aList = Appointments.getAll(id);
        JPanel temp = new JPanel();
        temp.setBackground(CustomColor.DARK_GREY);
        aList.forEach(app -> temp.add(new ProfileAppointmentPanel(app)));
        return temp;
    }

    private JLabel setLabel(String s, Color c, int size) { return setLabel(s, c, size, true); }
    private JLabel setLabel(String s, Color c, int size, boolean aa) {
        JLabel j;
        if(aa) j = new AALabel(s, SwingConstants.CENTER);
        else j = new JLabel(s, SwingConstants.CENTER);
        j.setFont(getFont(size));
        j.setForeground(c);
        j.setAlignmentX(CENTER_ALIGNMENT);
        return j;
    }

    private Font getFont(int size) {
        Font f = ResourceHandler.createFont("res/Helvetica_Neue.otf");
        return f.deriveFont(Font.PLAIN, size);
    }

}
