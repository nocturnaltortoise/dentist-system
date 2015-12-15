package views;

import models.Patient;
import views.components.ProfilePanel;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    public ProfileView(Patient p, boolean sec) {
        setSize(500,600);
        setTitle("Profile: " + p.getName());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();

        ProfilePanel profilePanel = new ProfilePanel(p, sec);
        contentPane.add(profilePanel);

        setVisible(true);
    }

}
