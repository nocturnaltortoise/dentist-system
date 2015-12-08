import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProfilePanel extends JPanel {

    private final int PADDING = 20;

    public ProfilePanel(Patient p) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setBackground(CustomColor.DARK_GREY);

        ImageIcon icon = ResourceHandler.createImageIcon("res/profile_icon.png");
        JLabel image = new JLabel(icon, SwingConstants.CENTER);
        image.setAlignmentX(CENTER_ALIGNMENT);
        image.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        JLabel nameLabel = setLabel(p.getName().toString(), Color.WHITE, 36);
        JLabel dobLabel = setLabel(p.getDateOfBirth().toString(), CustomColor.LIGHT_GREY, 30);
        JLabel pLabel = setLabel(p.getPhone(), Color.WHITE, 24);
        JLabel addLabel = setLabel(p.getAddress().toString(), CustomColor.LIGHT_GREY, 24, false);

        add(image);
        add(nameLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(dobLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(pLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(addLabel);

    }

    private JLabel setLabel(String s, Color c, int size) { return setLabel(s, c, size, true); }
    private JLabel setLabel(String s, Color c, int size, boolean aa) {
        JLabel j;
        if(aa) j = new AALabel(s, SwingConstants.CENTER);
        else j = new JLabel(s, SwingConstants.CENTER);
        j.setFont(getFont(size));
        j.setForeground(c);
        j.setAlignmentX(CENTER_ALIGNMENT);
        return j;
    }

    private Font getFont(int size) {
        Font f = ResourceHandler.createFont("res/Helvetica_Neue.otf");
        return f.deriveFont(Font.PLAIN, size);
    }

}
