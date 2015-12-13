package views.components;

import javax.swing.*;
import java.awt.*;

public class PatientDialog extends JDialog{

    private AddPatientPanel patientPanel = new AddPatientPanel(this);

    public PatientDialog(JFrame parent){
        super(parent, "Add New Patient", true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();

        contentPane.add(patientPanel);
        pack();
        setVisible(true);
    }

}
