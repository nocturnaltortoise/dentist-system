package views;

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
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        JLabel prompt = new JLabel("Select one:");
        prompt.setAlignmentX(CENTER_ALIGNMENT);
        JPanel options = new JPanel();
        options.add(startPartnerViewButton);
        options.add(startSecretaryViewButton);

        contentPane.add(prompt);
        contentPane.add(options);

        startPartnerViewButton.addActionListener(this);
        startSecretaryViewButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == startSecretaryViewButton){
            new SecretaryView();
            this.dispose();
        }else{
            new PartnerView();
            this.dispose();
        }
    }
}
