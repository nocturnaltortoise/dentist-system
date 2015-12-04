import javax.swing.*;
import java.awt.*;

public class ApplicationSelectorView extends JFrame {

    public ApplicationSelectorView(int width, int height) {
        setTitle("Dentist System");
        setSize(width, height);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        JButton startPartnerViewButton = new JButton("Partners");
        JButton startSecretaryViewButton = new JButton("Secretary");

        contentPane.add(startPartnerViewButton);
        contentPane.add(startSecretaryViewButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
