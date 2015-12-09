import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentPanel extends JPanel{

    private Patient patient;

    public AppointmentPanel(Appointment app) {
        super();
        patient = app.getPatient();
        PatientButton patientButton = new PatientButton(patient);
        String type = app.getType().toString();
        Time startTime = app.getStartTime();
        Time endTime = app.getendTime();
        JLabel appointmentInfo = new JLabel();
        appointmentInfo.setText("<html>" + type + "<br>" + startTime + " - " + endTime + "</html>");

        add(appointmentInfo);
        add(patientButton);
    }

    /*
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }
    */

}
