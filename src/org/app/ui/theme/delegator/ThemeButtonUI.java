package org.app.ui.theme.delegator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class ThemeButtonUI extends BasicButtonUI {

    private ButtonModel model;

    @Override
    public void installUI(JComponent c) {

        super.installUI(c);
        JButton button = (JButton) c;
        model = button.getModel();
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setRolloverEnabled(true);
        button.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
        button.setRolloverEnabled(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        JButton button = (JButton) c;
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics fm = g2d.getFontMetrics();
        String text = button.getText();
        g2d.setColor(button.getModel().isRollover() ? button.getBackground().brighter() : button.getBackground().darker());
        g2d.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 10, 10);
        g2d.setColor(button.getBackground().darker());
        g2d.drawRoundRect(0, 0, button.getWidth() - 1, button.getHeight() - 1, 10, 10);
        button.getModel().setPressed(button.getIcon() == null || !button.getModel().isRollover());
        super.paint(g2d, button);
        g2d.dispose();
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {

        Graphics2D g2d = (Graphics2D) g.create();
        AbstractButton b = (AbstractButton) c;
        FontMetrics fm = g2d.getFontMetrics();
        g2d.setColor(b.getForeground());
        int x = textRect.x;
        int y = textRect.y + fm.getAscent() - (model.isRollover() ? 2 : 0);
        g2d.drawString(text, x, y);
        g2d.dispose();
    }

    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        Icon icon = b.getIcon();
        Icon tmpIcon = null;

        if (icon == null) {
            return;
        }

        Icon selectedIcon = null;

        /* the fallback icon should be based on the selected state */
        if (model.isSelected()) {
            selectedIcon = b.getSelectedIcon();
            if (selectedIcon != null) {
                icon = selectedIcon;
            }
        }

        if (!model.isEnabled()) {
            if (model.isSelected()) {
                tmpIcon = b.getDisabledSelectedIcon();
                if (tmpIcon == null) {
                    tmpIcon = selectedIcon;
                }
            }

            if (tmpIcon == null) {
                tmpIcon = b.getDisabledIcon();
            }
        } else if (model.isPressed() && model.isArmed()) {
            tmpIcon = b.getPressedIcon();
            if (tmpIcon != null) {
                // revert back to 0 offset
                clearTextShiftOffset();
            }
        } else if (b.isRolloverEnabled() && model.isRollover()) {
            if (model.isSelected()) {
                tmpIcon = b.getRolloverSelectedIcon();
                if (tmpIcon == null) {
                    tmpIcon = selectedIcon;
                }
            }

            if (tmpIcon == null) {
                tmpIcon = b.getRolloverIcon();
            }
        }

        if (tmpIcon != null) {
            icon = tmpIcon;
        }

        icon.paintIcon(c, g, iconRect.x, iconRect.y - (model.isRollover() ? 2 : 0));
    }

    @Override
    protected int getTextShiftOffset() {
        return super.getTextShiftOffset() - (model.isRollover() ? 2 : 0);
    }
}
