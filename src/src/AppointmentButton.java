import javax.swing.*;
import java.awt.*;

public class AppointmentButton extends JButton {

    public AppointmentButton(Appointment app) {
        super("");
        String name = app.getPatient().getName().getFullName();
        String type = app.getType().toString();
        Time startTime = app.getStartTime();
        Time endTime = app.getendTime();
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
