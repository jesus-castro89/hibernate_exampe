package org.app.ui.theme.components;


import org.app.ui.theme.delegator.ThemeButtonUI;

import javax.swing.*;

public class ThemeButton extends JButton {

    public ThemeButton() {
        super();
        setUI(new ThemeButtonUI());
    }

    public ThemeButton(Icon icon) {
        this();
        setIcon(icon);
    }
}
