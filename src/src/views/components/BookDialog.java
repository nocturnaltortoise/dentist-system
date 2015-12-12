package views.components;

import javax.swing.*;
import java.awt.*;

public class BookDialog extends JDialog {

    public BookDialog(JFrame parent) {
        super(parent, "Book Appointment", true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();

        BookPanel dpanel = new BookPanel();

        contentPane.add(dpanel);
        pack();
        setVisible(true);
    }

}
