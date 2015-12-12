package views.components;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarPanel extends JPanel {

    public CalendarPanel(LocalDate currentDate) {
        setLayout(new BorderLayout());
        JLabel title = new JLabel(currentDate.getMonth().toString() + " " + currentDate.getYear(), SwingConstants.RIGHT);
        title.setOpaque(true);
        title.setBackground(new Color(37,90,108));
        title.setForeground(new Color(130,205,230));
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,30)); //adds padding to the title
        add(title, BorderLayout.NORTH);

    }

}
