package views.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PartnerMenu extends JMenuBar implements ActionListener {

    private static JMenuItem recordTreatment;

    public PartnerMenu(){

        JMenu appointmentsMenu = new JMenu("Treatments");
        appointmentsMenu.setMnemonic(KeyEvent.VK_T);

        recordTreatment = new JMenuItem("Record Treatment Visit");
        recordTreatment.addActionListener(this);
        appointmentsMenu.add(recordTreatment);

        add(appointmentsMenu);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == recordTreatment){
            //popup dialog asking for details of treatment
                //add treatment
        }
    }

}
