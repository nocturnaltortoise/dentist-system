package views.components;

import models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfilePanel extends JPanel implements ActionListener {

    private final int PADDING = 20;
    private Patient patient;
    private JComboBox healthcarePlanInput;
    private JButton submit;
    private boolean isSecretary;
    private JFrame parent;

    public ProfilePanel(Patient p, boolean sec, JFrame parent) {
        super();
        this.parent = parent;
        this.patient = p;
        this.isSecretary = sec;
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

        appointments.setLayout(new BoxLayout(appointments, BoxLayout.PAGE_AXIS));

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
            totalCost -= treatment.getAmountPaid();
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
            healthcarePlanInput = new JComboBox(HealthcarePlan.values());
            healthcarePlanInput.setSelectedItem(p.getPlan());
            healthcarePlanInput.setAlignmentX(CENTER_ALIGNMENT);
            healthcarePlanInput.addActionListener(this);
            add(healthcarePlanLabel);
            add(healthcarePlanInput);
        }
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(appointments);
        add(treatmentTotalCost);
        add(treatments);

    }

    public void rebuildProfilePanel(){
        this.parent.remove(this);
        System.out.println(this.parent);
        this.parent.add(new ProfilePanel(this.patient, this.isSecretary, this.parent));
        this.parent.revalidate();
        this.parent.repaint();
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
        tList.forEach(treatment -> temp.add(new ProfileTreatmentPanel(treatment, this)));
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

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == healthcarePlanInput &&
                healthcarePlanInput.getSelectedItem().toString() != patient.getPlan().toString()) {
            patient.setPlan(healthcarePlanInput.getSelectedItem().toString());
            Patients.changePlan(patient, healthcarePlanInput.getSelectedItem().toString());
        }
    }
}
