package views.components;

import javax.swing.*;
import java.awt.*;

public class AALabel extends JLabel {

    public AALabel(String t) { super(t); }
    public AALabel(String t, int c) { super(t, c); }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        char[] c = getText().toCharArray();

        FontMetrics fm = getFontMetrics(getFont());
        int h = fm.getAscent();
        g2.setFont(getFont());

        int x = 0;

        for (int i = 0; i < c.length; i++) {
            g2.drawString("" + c[i], x, h);
            x += fm.charWidth(c[i]);
        }

    }

}
