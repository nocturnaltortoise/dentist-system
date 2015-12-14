package views.components;

import models.Appointment;
import models.Appointments;
import models.TestAppointments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchDialog extends JDialog implements ActionListener {

    private SearchPanel dpanel;
    private ResultPanel resultPanel;

    public SearchDialog(JFrame parent) {
        super(parent, "Search for Appointment", true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();

        dpanel = new SearchPanel();
        dpanel.getButton().addActionListener(this);

        contentPane.add(dpanel);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(dpanel.getInput().getText() != "") {
            if(resultPanel != null){ dpanel.remove(resultPanel); }
            System.out.println("Here");
            int patientIDQuery = Integer.valueOf(dpanel.getInput().getText());
            ArrayList<Appointment> results = Appointments.getAll(patientIDQuery);
            resultPanel = new ResultPanel(results);
            resultPanel.setAlignmentX(CENTER_ALIGNMENT);
            revalidate();
            repaint();
            getContentPane().add(dpanel);
            dpanel.add(resultPanel);
            pack();
        }
    }
}
