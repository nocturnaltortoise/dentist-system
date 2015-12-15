package views.components;

import models.Patient;
import models.Patients;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPanel extends JPanel implements ActionListener {

    private final int PADDING = 20;
    private JButton searchButton;
    private InputArea searchArea;
    private JButton submit;

    public SearchPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        JLabel searchLabel = new JLabel("Enter a patient's surname:", SwingConstants.LEFT);
        searchLabel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel searchQPanel = new JPanel();
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchArea = new InputArea("", 300);
        searchQPanel.add(searchArea);
        searchQPanel.add(searchButton);

        searchQPanel.setAlignmentX(CENTER_ALIGNMENT);
        submit = new JButton("Show Appointments");
        submit.setAlignmentX(CENTER_ALIGNMENT);

        add(searchLabel);
        add(searchQPanel);
        add(Box.createRigidArea(new Dimension(0, PADDING)));
        add(submit);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == searchButton && !searchArea.getText().equals("")) {
            ArrayList<Patient> results = Patients.getByName(searchArea.getText());
            if(results.size() > 0) {
                Object[] resultsArr = results.toArray();
                Patient pat = (Patient) JOptionPane.showInputDialog(
                        null,
                        "Select a patient: ",
                        "Search: ",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        resultsArr,
                        resultsArr[0]);
                if (pat != null) searchArea.setText("" + pat.getId());
            }else {
                JOptionPane.showMessageDialog(this, "No results found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public JButton getButton() { return submit; }
    public InputArea getInput() { return searchArea; }
}
