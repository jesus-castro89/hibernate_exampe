package org.app.ui.theme;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ThemeManager {

    public static void applyTheme(Theme theme) {

        UIManager.put("Panel.background", theme.primary);

        UIManager.put("Button.background", theme.primary);
        UIManager.put("Button.foreground", theme.background);
        UIManager.put("Button.font", theme.font.deriveFont(Font.BOLD));

        UIManager.put("Label.foreground", theme.text);
        UIManager.put("Label.font", theme.font);

        UIManager.put("TabbedPane.selected", theme.primary);
        UIManager.put("TabbedPane.focus", theme.primary);
        UIManager.put("TabbedPane.foreground", theme.background);
        UIManager.put("TabbedPane.font", theme.font);
        UIManager.put("TabbedPane.background", theme.primary.darker());
        UIManager.put("TabbedPane.selected", theme.primary);
        UIManager.put("TabbedPane.tabAreaBackground", theme.background);
        UIManager.put("TabbedPane.darkShadow", theme.primary.darker());
        UIManager.put("TabbedPane.highlight", theme.primary.darker().darker());
        UIManager.put("TabbedPane.borderHightlightColor", theme.primary.darker().darker());
        UIManager.put("TabbedPane.tabsOpaque", true);
        UIManager.put("TabbedPane.tabInsets", new Insets(5, 5, 5, 5));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(5, 5, 5, 5));
        UIManager.put("TabbedPane.font", theme.font.deriveFont(Font.BOLD));

        UIManager.put("TextField.background", theme.background);
        UIManager.put("TextField.highlight", theme.primary);
        UIManager.put("TextField.foreground", theme.text);
        UIManager.put("TextField.font", theme.font);
        UIManager.put("TextField.margin", new Insets(5, 1, 5, 1));

        UIManager.put("Table.background", theme.background);
        UIManager.put("Table.foreground", theme.text);
        UIManager.put("Table.font", theme.font);
        UIManager.put("Table.gridColor", theme.primary.darker());
        UIManager.put("Table.selectionBackground", theme.primary);
        UIManager.put("Table.selectionForeground", theme.background);

        Border tableBorder = new BevelBorder(BevelBorder.LOWERED, theme.primary.darker(),
                theme.primary, theme.primary.brighter(), theme.primary);
        UIManager.put("TableHeader.font", theme.font);
        UIManager.put("TableHeader.background", theme.primary);
        UIManager.put("TableHeader.cellBorder", tableBorder);
        UIManager.put("TableHeader.foreground", theme.background);
        UIManager.put("TableHeader.focusCellBackground", theme.primary.darker());

        UIManager.put("defaultFont", theme.font);
    }
}
