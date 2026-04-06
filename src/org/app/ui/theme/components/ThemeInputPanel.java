package org.app.ui.theme.components;

import org.app.ui.theme.delegator.ThemeLabelUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Predicate;

public class ThemeInputPanel<T> extends JPanel {

    private final ThemeInput<T> inputField;
    private final JLabel label;
    private final Component parentComponent;
    private boolean validField;

    public ThemeInputPanel(String fieldName, String hintText, String errorMessage, Predicate<T> predicate, Component parentComponent) {

        this.parentComponent = parentComponent;
        this.inputField = new ThemeInput<>(fieldName, hintText, errorMessage, predicate);
        this.label = new JLabel(inputField.getErrorMessage());
        this.validField = true;
        initComponents();
    }

    private void initComponents() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        label.setUI(new ThemeLabelUI());
        label.setText(inputField.getErrorMessage());
        label.setVisible(false);
        label.setForeground(Color.RED);
        label.setFont(label.getFont().deriveFont(Font.ITALIC));
        inputField.setAlignmentX(Component.LEFT_ALIGNMENT);
        inputField.setParentPanel(this);
        add(inputField);
        add(label);
    }

    public void validateInput() {

        validField = inputField.isValidField();
        label.setVisible(!validField);
        parentComponent.revalidate();
        parentComponent.repaint();
    }

    public boolean isValidField() {
        return validField;
    }

    public String getText() {

        return inputField.getText();
    }
}
