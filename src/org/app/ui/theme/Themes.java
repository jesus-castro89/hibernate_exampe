package org.app.ui.theme;

import org.app.ui.theme.colors.MainThemeColors;

public class Themes {
    public static Theme LIGHT = new Theme(
            MainThemeColors.PRIMARY,
            MainThemeColors.ON_PRIMARY,
            MainThemeColors.BACKGROUND,
            MainThemeColors.FOREGROUND,
            MainThemeColors.SECONDARY,
            new java.awt.Font("Arial", java.awt.Font.PLAIN, 18)
    );

    public static Theme DARK = new Theme(
            new java.awt.Color(0xBB86FC),
            new java.awt.Color(0xBB8B8B),
            new java.awt.Color(0x121212),
            new java.awt.Color(0xFFFFFF),
            new java.awt.Color(0x03DAC6),
            new java.awt.Font("Arial", java.awt.Font.PLAIN, 18)
    );
}