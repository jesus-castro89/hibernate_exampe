package org.app.ui.theme.components;

import org.app.ui.theme.delegator.ThemeTabbedPaneUI;

import javax.swing.*;

public class ThemeTabbedPane extends JTabbedPane {

    public ThemeTabbedPane() {
        super();
        setUI(new ThemeTabbedPaneUI());
    }
}
