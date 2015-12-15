package views.components;

import models.Treatment;

import javax.swing.*;

public class ProfileTreatmentPanel extends JPanel {

    public ProfileTreatmentPanel(Treatment treatment) {

        setBackground(CustomColor.LIGHT_GREY);
        JLabel info = new JLabel(treatment.getType().toString() + " | " + "£" + treatment.getType().getCost());
        add(info);
    }

}
