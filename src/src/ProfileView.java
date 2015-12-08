import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    public ProfileView(Patient p) {
        setSize(500,600);
        setTitle("Profile: " + p.getName());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();

        ProfilePanel profilePanel = new ProfilePanel(p);
        contentPane.add(profilePanel);

        setVisible(true);
    }

}
