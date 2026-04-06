package org.app.ui.theme.components;

import org.app.ui.theme.delegator.RoundBorder;
import org.app.ui.theme.delegator.ThemeInputUI;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Predicate;

public class ThemeInput<T> extends JTextField {

    private String fieldName;
    private String hintText;          // Texto de la etiqueta flotante
    private String errorMessage;      // Mensaje de error (si hay)
    private boolean isFocused = false;
    private Color normalColor;
    private Color errorColor;
    private final Predicate<T> validator;
    private ThemeInputPanel<T> parentPanel;

    public ThemeInput(String fieldName, String hintText, String errorMessage, Predicate<T> validator) {

        setUI(new ThemeInputUI());
        this.fieldName = fieldName;
        this.validator = validator;
        this.hintText = hintText;
        this.errorMessage = errorMessage;
        normalColor = UIManager.getColor("TextField.highlight");
        errorColor = Color.RED;
        rebuildBorder(normalColor);

        FocusListener focusListener = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                isFocused = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                isFocused = false;
            }
        };
        addFocusListener(focusListener);
    }

    public void setParentPanel(ThemeInputPanel<T> parentPanel) {
        this.parentPanel = parentPanel;
    }

    public boolean isValidField() {

        if (!validator.test((T) getText())) {
            rebuildBorder(errorColor);
            return false;
        } else {
            rebuildBorder(normalColor);
            return true;
        }
    }

    private void rebuildBorder(Color color) {

        LineBorder border = new RoundBorder(color, 3, true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 10, 5, 10);
        CompoundBorder compoundBorder = new CompoundBorder(border, emptyBorder);
        TitledBorder titledBorder = new TitledBorder(compoundBorder, fieldName);
        setBorder(titledBorder);
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
        getBorder().paintBorder(this, g2, 0, 0, getWidth(), getHeight());
        // Dibujamos el hint siempre que el campo esta vacio
        if (!isFocused && getText().isEmpty()) {
            g2.setColor(getForeground().brighter().brighter().brighter().brighter());
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.drawString(hintText, x + 10, y + h / 2 + g2.getFontMetrics().getAscent() / 2 - 2);
        }
        // Dibujamos el resto con la clase padre
        super.paintComponent(g2);
        // Pintar la etiqueta flotante
        g2.dispose();
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
