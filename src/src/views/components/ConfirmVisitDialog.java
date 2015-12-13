package views.components;

import models.Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfirmVisitDialog extends JDialog implements ActionListener {

    private JPanel treatmentsPanel;
    private JButton addTreatment;
    private JButton submit;
    private ArrayList<ConfirmVisitPanel> panelList = new ArrayList<>();
    private Appointment app;

    public ConfirmVisitDialog(JFrame parent, Appointment app){
        super(parent, "Record Visit", true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        this.app = app;

        Container contentPane = getContentPane();
        treatmentsPanel = new JPanel();
        treatmentsPanel.setLayout(new BoxLayout(treatmentsPanel, BoxLayout.PAGE_AXIS));

        contentPane.add(treatmentsPanel);

        JPanel buttonPanel = new JPanel();
        addTreatment = new JButton("Add Another Treatment");
        addTreatment.addActionListener(this);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        buttonPanel.add(addTreatment);
        buttonPanel.add(submit);

        contentPane.add(buttonPanel, BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == addTreatment){
            ConfirmVisitPanel newPanel = new ConfirmVisitPanel(this.app);

            panelList.add(newPanel);
            panelList.forEach(panel -> treatmentsPanel.add(panel)); //look, I can java 8!
            revalidate();
            repaint();
            pack();
        }else if(event.getSource() == submit){
            // should do something more useful than printing - like adding to a patient's list of treatments
            panelList.forEach(panel -> System.out.println(panel.getTreatment()));
            this.dispose();
        }

    }


}
