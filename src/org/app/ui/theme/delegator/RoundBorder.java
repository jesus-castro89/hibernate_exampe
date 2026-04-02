package org.app.ui.theme.delegator;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RoundBorder extends LineBorder {


    public RoundBorder(Color color) {
        super(color);
    }

    public RoundBorder(Color color, int thickness) {
        super(color, thickness);
    }

    public RoundBorder(Color color, int thickness, boolean roundedCorners) {
        super(color, thickness, roundedCorners);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(thickness));
        int arc = thickness * 4; // Ajusta el valor para redondear más o menos
        g2d.drawRoundRect(x + thickness / 2, y + thickness / 2,
                width - thickness, height - thickness, arc, arc);
        g2d.dispose();
    }
}
