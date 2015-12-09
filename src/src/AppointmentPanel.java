import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentPanel extends JPanel{

    private final int PADDING = 10;
    private Patient patient;

    public AppointmentPanel(Appointment app, boolean sec) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        patient = app.getPatient();
        PatientButton patientButton = new PatientButton(patient);
        patientButton.setAlignmentX(CENTER_ALIGNMENT);

        String type = app.getType().toString();
        Time startTime = app.getStartTime();
        Time endTime = app.getendTime();
        JLabel appointmentInfo = new JLabel("<html><center>" + type + "<br>" + startTime + " - " + endTime + "</center></html>", JLabel.CENTER);
        appointmentInfo.setAlignmentX(CENTER_ALIGNMENT);

        add(patientButton);
        add(appointmentInfo);

        if(sec) {
            CancelButton cancelButton = new CancelButton(patient.getName().toString());
            cancelButton.setAlignmentX(CENTER_ALIGNMENT);
            add(cancelButton);
        }

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
