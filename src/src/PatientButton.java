import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientButton extends JButton implements ActionListener{

    private Patient patient;

    public PatientButton(Patient patient) {
        super("");
        this.patient = patient;
        String name = patient.getName().toString();
        setText(name);
        //setBounds(getX(), getY(), panel.getWidth(), panel.getHeight());

        //Button settings
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        new ProfileView(patient);
    }


}
