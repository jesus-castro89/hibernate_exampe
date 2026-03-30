package org.app.ui.theme.components;

import org.app.ui.theme.ThemeManager;
import org.app.ui.theme.delegator.TabbedPaneUI;

import javax.swing.*;

public class ThemeTabbedPane extends JTabbedPane {

    public ThemeTabbedPane() {
        super();
        setUI(new TabbedPaneUI());
    }
}
