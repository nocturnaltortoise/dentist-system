import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SecretaryDialog extends JDialog {

    public SecretaryDialog(JFrame parent, DialogType t) {
        super(parent, "", true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();

        JPanel dpanel;
        switch(t){
            case CANCEL: dpanel = createCancel(); break;
            case SEARCH: dpanel = createSearch(); break;
            default: dpanel = createBook();
        }

        contentPane.add(dpanel);
        pack();
        setVisible(true);
    }

    private JPanel createBook() {
        setTitle("Book Appointment");
        return new BookPanel();
    }
    private JPanel createCancel() {
        setTitle("Cancel Appointment");
        return null;
    }
    private JPanel createSearch() {
        setTitle("Search for Appointment");
        return null;
    }

}
