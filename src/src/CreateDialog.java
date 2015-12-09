import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateDialog extends JDialog {

    public CreateDialog(JFrame parent) {
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
