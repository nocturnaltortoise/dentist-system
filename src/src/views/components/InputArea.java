package views.components;

import javax.swing.*;
import java.awt.*;

public class InputArea extends JTextArea {

    private int width;
    private Dimension size;

    public InputArea(String s, int width) {
        super(s);
        this.width = width;
        size = new Dimension(this.width, 20);
        setEditable(true);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        setAlignmentX(LEFT_ALIGNMENT);
    }

}
