package org.app.ui.theme.delegator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class ThemeLabelUI extends BasicLabelUI {

    @Override
    public void installUI(JComponent c) {

        c.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension size = super.getPreferredSize(c);
        size.width += 20;
        size.height += 20;
        return size;
    }
}
