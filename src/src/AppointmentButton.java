import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentButton extends JButton implements ActionListener {

    private Patient patient;

    public AppointmentButton(Appointment app) {
        super("");
        patient = app.getPatient();
        String name = patient.getName().toString();
        String type = app.getType().toString();
        Time startTime = app.getStartTime();
        Time endTime = app.getendTime();
        setText("<html>" + name + "<br>" + type + "<br>" + startTime + " - " + endTime + "</html>");

        //Button settings
        setOpaque(true);
        //setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        new ProfileView(patient);
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
