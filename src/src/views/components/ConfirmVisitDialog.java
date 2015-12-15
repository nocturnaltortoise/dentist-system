package views.components;

import models.Appointment;
import models.Treatment;
import models.Treatments;

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
    private CompleteButton button;

    public ConfirmVisitDialog(JFrame parent, Appointment app, CompleteButton button){
        super(parent, "Record Visit", true);
        this.button = button;
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

//    private boolean anyEmpty() {
//        boolean empty = false;
//        for(ConfirmVisitPanel i : panelList) { if(i.isEmpty()) empty = true; break; }
//        return empty;
//    }
//
//    private boolean anyNotInt() {
//        boolean notInt = false;
//        for(ConfirmVisitPanel i : panelList) { if(!i.isInt()) notInt = true; break; }
//        return notInt;
//    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == addTreatment){
            ConfirmVisitPanel newPanel = new ConfirmVisitPanel(this.app);

            panelList.add(newPanel);
            panelList.forEach(panel -> treatmentsPanel.add(panel));
            revalidate();
            repaint();
            pack();
        }else if(event.getSource() == submit && panelList.size() > 0){
//            if(anyEmpty()) JOptionPane.showMessageDialog(this, "You must enter a treatment cost.", "Error", JOptionPane.ERROR_MESSAGE);
//            else if(anyNotInt()) JOptionPane.showMessageDialog(this, "Treatment costs must be integers.", "Error", JOptionPane.ERROR_MESSAGE);
//            else {
                for(ConfirmVisitPanel panel : panelList){
                    Treatment newTreatment = panel.getTreatment();
                    int appId = newTreatment.getApp().getAppId();
                    String treatmentName = newTreatment.getType().toString();

                    Treatments.add(newTreatment);
                }
//                panelList.forEach(panel -> System.out.println(panel.getTreatment()));
                button.setEnabled(false);
                this.dispose();
//            }
        }

    }


}
