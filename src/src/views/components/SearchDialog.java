package views.components;

import models.TestAppointments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDialog extends JDialog implements ActionListener {

    private SearchPanel dpanel;

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
        //TODO: Link up with SQL. SQL is love. SQL is life. I'm really tired. Sorry Simon. gg bob ross. meme.
        //Code for displaying search results
        //For now, a temporary search result is constantly displayed
        if(dpanel.getInput().getText() != "") {
            System.out.println("Here");
            ResultPanel temp = new ResultPanel(TestAppointments.appointments[0]);
            temp.setAlignmentX(CENTER_ALIGNMENT);
            dpanel.add(temp);
            pack();
        }
    }
}
