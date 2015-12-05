import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationSelectorView extends JFrame implements ActionListener{

    JButton startPartnerViewButton = new JButton("Partners");
    JButton startSecretaryViewButton = new JButton("Secretary");

    public ApplicationSelectorView(int width, int height) {
        setTitle("Dentist System");
        setSize(width, height);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(startPartnerViewButton);
        contentPane.add(startSecretaryViewButton);

        startPartnerViewButton.addActionListener(this);
        startSecretaryViewButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == startSecretaryViewButton){
            new CalendarView();
            this.dispose();
        }
    }
}
