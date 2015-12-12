package views.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteButton extends JButton implements ActionListener {

    public CompleteButton() {
        super("Complete");

        //Button settings
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        int button = JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog(this, "Testing...", "Complete", button);
        if(answer == JOptionPane.YES_OPTION) {
            //Cancel
        }
    }
}
