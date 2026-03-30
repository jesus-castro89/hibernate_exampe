package org.app.ui.theme;

import java.awt.*;

public class Theme {
    public Color primary;
    public Color onPrimary;
    public Color background;
    public Color text;
    public Color accent;
    public Font font;

    public Theme(Color primary, Color onPrimary, Color background, Color text, Color accent, Font font) {
        this.primary = primary;
        this.onPrimary = onPrimary;
        this.background = background;
        this.text = text;
        this.accent = accent;
        this.font = font;
    }
}
