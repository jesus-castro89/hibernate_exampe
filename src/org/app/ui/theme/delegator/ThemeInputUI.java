package org.app.ui.theme.delegator;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.plaf.metal.MetalTextFieldUI;
import java.awt.*;
import java.awt.event.FocusAdapter;

public class ThemeInputUI extends BasicTextFieldUI {

    @Override
    public void installUI(javax.swing.JComponent c) {

        super.installUI(c);
        c.setBackground(UIManager.getColor("TextField.background"));
        c.setOpaque(false);
        LineBorder border = new RoundBorder(UIManager.getColor("TextField.highlight"), 3,
                true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 10, 5, 10);
        c.setBorder(new CompoundBorder(border, emptyBorder));
    }


}
