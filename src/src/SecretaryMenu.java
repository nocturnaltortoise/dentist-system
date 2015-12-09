import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SecretaryMenu extends JMenuBar implements ActionListener {

    private static JMenuItem bookAppointment;
    private static JMenuItem cancelAppointment;
    private static JMenuItem findPatientsAppointments;

    public SecretaryMenu(){

        JMenu appointmentsMenu = new JMenu("Appointments");
        appointmentsMenu.setMnemonic(KeyEvent.VK_A);

        bookAppointment = new JMenuItem("Book Appointment");
        cancelAppointment = new JMenuItem("Cancel Appointment");
        findPatientsAppointments = new JMenuItem("Find a Patient's Appointments");
        appointmentsMenu.add(bookAppointment);
        appointmentsMenu.add(cancelAppointment);
        appointmentsMenu.add(findPatientsAppointments);

        add(appointmentsMenu);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == bookAppointment){
            //popup dialog asking for appointment details
                //add appointment with those details
        }else if(event.getSource() == cancelAppointment){
            //popup dialog with search bar to search for appointment
                //display list of search results
                    //let the user select an appointment and hit an ok button
                        //cancel that appointment
        }else{
            //popup dialog with search bar for searching patients
                //display search results of patients (probably patient buttons)
                    //let the user click on each patient to display a profile
        }
    }

}
