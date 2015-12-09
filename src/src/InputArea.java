import javax.swing.*;
import java.awt.*;

public class InputArea extends JTextArea {

    private int width;
    private Dimension size;

    public InputArea(String s, int width) {
        super(s);
        this.width = width;
        size = new Dimension(width, 40);
        setEditable(true);
        setMinimumSize(size);
        setMaximumSize(size);
        setAlignmentX(LEFT_ALIGNMENT);
    }

}
