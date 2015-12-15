package views.components;

import models.Appointment;
import models.AppointmentType;
import models.Treatment;
import models.TreatmentType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ConfirmVisitPanel extends JPanel {

    private static final int PADDING = 20;
    private static final int TEXTBOX_SIZE = 300;

    private JComboBox<TreatmentType> treatmentType;
    private JTextArea costInput;
    private JLabel costLabel;
    private JLabel treatmentTypeLabel;
    private Appointment app;

    public ConfirmVisitPanel(Appointment app){
        super();

        this.app = app;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        treatmentTypeLabel = new JLabel("Treatment Type: ");
        treatmentType = new JComboBox<>(TreatmentType.values());
        treatmentType.setAlignmentX(LEFT_ALIGNMENT);

        costLabel = new JLabel("Cost: ");
        costInput = new InputArea("", TEXTBOX_SIZE);

        add(treatmentTypeLabel);
        add(treatmentType);
        add(costLabel);
        add(costInput);
    }

    public boolean isEmpty() { return costInput.getText().equals(""); }
    public boolean isInt() {
        try {
            int num = Integer.parseInt(costInput.getText());
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Treatment getTreatment(){
        return new Treatment((TreatmentType)treatmentType.getSelectedItem(), this.app);
    }


}
