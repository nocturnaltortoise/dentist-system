import javax.swing.*;
import java.awt.*;

/**
 * Created by George Baron on 06/12/2015.
 */

public class AppointmentButton extends JButton {

    //Variables
    private Appointment app;
    private String name;
    private String type;
    private Time startTime;
    private Time endTime;

    public AppointmentButton(Appointment a) {
        super("");
        app = a;
        name = app.getPatient().getName().getFullName();
        type = app.getType().toString();
        startTime = app.getStartTime();
        endTime = app.getendTime();
        setText("<html>" + name + "<br>" + type + "<br>" + startTime + " - " + endTime + "</html>");

        //Button settings
        setOpaque(true);
        //setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
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
