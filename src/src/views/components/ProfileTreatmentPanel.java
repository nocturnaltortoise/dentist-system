package views.components;

import models.Treatment;
import models.Treatments;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileTreatmentPanel extends JPanel implements ActionListener{

    private JTextArea cost;
    private JButton saveChanges;
    private Treatment treatment;
    private ProfilePanel parent;

    public ProfileTreatmentPanel(Treatment treatment, ProfilePanel parent) {
        this.parent = parent;
        this.treatment = treatment;
        setBackground(CustomColor.LIGHT_GREY);
        JLabel info = new JLabel(treatment.getType().toString() + " | " + "£");
        cost = new InputArea("" + (treatment.getAmountPaid()), 50);
        saveChanges = new JButton("Save Changes");
        saveChanges.addActionListener(this);
        add(info);
        add(cost);
        add(saveChanges);

    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == saveChanges){
            double newCost = Double.valueOf(cost.getText());
            treatment.setAmountPaid(newCost);
            Treatments.updateAmountPaid(treatment.getApp().getAppId(), newCost);
            this.parent.rebuildProfilePanel();
        }
    }

}
