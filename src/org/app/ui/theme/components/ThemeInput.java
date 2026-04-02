package org.app.ui.theme.components;

import org.app.ui.theme.delegator.RoundBorder;
import org.app.ui.theme.delegator.ThemeInputUI;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ThemeInput extends JTextField {
    private String hintText;          // Texto de la etiqueta flotante
    private String errorMessage;      // Mensaje de error (si hay)
    private boolean isFocused = false;
    private Color normalColor;
    private Color errorColor;

    // Animación de la etiqueta (opcional)
    private float labelAnimation = 0f; // 0 = abajo, 1 = arriba
    private Timer animationTimer;

    public ThemeInput() {
        this("", "");
    }

    public ThemeInput(String hintText, String errorMessage) {

        setUI(new ThemeInputUI());
        this.hintText = hintText;
        this.errorMessage = errorMessage;
        normalColor = UIManager.getColor("TextField.highlight");
        errorColor = Color.RED;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private void rebuildBorder(Color color) {
        LineBorder border = new RoundBorder(color, 3, true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 10, 5, 10);
        setBorder(new CompoundBorder(border, emptyBorder));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth() - 6;
        int h = getHeight() - 6;
        int x = getInsets().left / 4;
        int y = getInsets().top / 4;
        // Fondo
        g2.setColor(getBackground());
        g2.fillRoundRect(x, y, w, h, 12, 12);
        // Borde
        if (errorMessage != null && !errorMessage.isEmpty()) {
            rebuildBorder(errorColor);
        } else {
            rebuildBorder(normalColor);
        }
        getBorder().paintBorder(this, g2, 0, 0, getWidth(), getHeight());
        super.paintComponent(g2);
        // Pintar la etiqueta flotante
        g2.dispose();
    }

    private void paintFloatingLabel(Graphics2D g2) {
        if (hintText == null || hintText.isEmpty()) return;

        // Color de la etiqueta: primario si está enfocado, gris si no, rojo si error
        Color labelColor;
        if (errorMessage != null && !errorMessage.isEmpty()) {
            labelColor = Color.RED;
        } else if (isFocused) {
            labelColor = getBackground().brighter();
        } else {
            labelColor = Color.GRAY;
        }
        g2.setColor(labelColor);
        g2.setFont(getFont());

        // Calcular posición Y según si está flotando o no
        float y = 0;
        if (!(labelAnimation > 0.5f) && !isFocused && getText().isEmpty()) {
            // Dentro del campo, centrado verticalmente
            y = (float) (getHeight() + getFontMetrics(getFont()).getAscent()) / 2 - 2;
            g2.drawString(hintText, 12, y);
        } else {
            TitledBorder titledBorder = BorderFactory.createTitledBorder(getBorder(), hintText);
            setBorder(titledBorder);
        }
    }

    private Color getBorderColor() {
        if (errorMessage != null && !errorMessage.isEmpty()) return Color.RED;
        if (isFocused) return UIManager.getColor("TextField.highlight").darker();
        return UIManager.getColor("TextField.highlight").brighter();
    }
}
