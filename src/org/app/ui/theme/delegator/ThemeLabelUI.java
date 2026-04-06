package org.app.ui.theme.delegator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class ThemeLabelUI extends BasicLabelUI {

    @Override
    protected void installDefaults(JLabel c) {
        super.installDefaults(c);
        c.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setColor(l.getForeground());
        g2d.setFont(l.getFont());
        g2d.drawString(s, textX, textY);
    }
}
