import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {

    private final int PADDING = 20;
    private InputArea searchArea;
    private JButton submit;

    public SearchPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel searchLabel = new JLabel("Enter a patient's name:", SwingConstants.LEFT);
        searchLabel.setAlignmentX(CENTER_ALIGNMENT);
        searchArea = new InputArea("", 300);
        searchArea.setAlignmentX(CENTER_ALIGNMENT);
        submit = new JButton("Search");
        submit.setAlignmentX(CENTER_ALIGNMENT);

        add(searchLabel);
        add(searchArea);
        add(Box.createRigidArea(new Dimension(0, PADDING)));
        add(submit);

    }

    public JButton getButton() { return submit; }
    public InputArea getInput() { return searchArea; }
}
