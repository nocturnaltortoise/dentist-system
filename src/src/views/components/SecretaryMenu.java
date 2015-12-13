package views.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SecretaryMenu extends JMenuBar implements ActionListener {

    private JFrame parent;

    private static JMenuItem bookAppointment;
    private static JMenuItem findPatientsAppointments;
    private static JMenuItem addPatient;

    public SecretaryMenu(JFrame parent){

        this.parent = parent;

        JMenu appointmentsMenu = new JMenu("Appointments");
        appointmentsMenu.setMnemonic(KeyEvent.VK_A);

        bookAppointment = new JMenuItem("Book Appointment");
        findPatientsAppointments = new JMenuItem("Find a Patient's Appointments");
        bookAppointment.addActionListener(this);
        findPatientsAppointments.addActionListener(this);
        appointmentsMenu.add(bookAppointment);
        appointmentsMenu.add(findPatientsAppointments);

        JMenu patientsMenu = new JMenu("Patients");
        patientsMenu.setMnemonic(KeyEvent.VK_P);

        addPatient = new JMenuItem("Add New Patient");
        addPatient.addActionListener(this);
        patientsMenu.add(addPatient);

        add(appointmentsMenu);
        add(patientsMenu);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == bookAppointment){
            new BookDialog(parent);
        }else if(event.getSource() == findPatientsAppointments){
            //popup dialog with search bar for searching patients
                //display search results of patients (probably patient buttons)
                    //let the user click on each patient to display a profile
            new SearchDialog(parent);
        }else{
            new PatientDialog(parent);
        }
    }

}
