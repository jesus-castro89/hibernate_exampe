package org.app.ui;

import com.github.lgooddatepicker.components.DatePicker;
import org.app.ui.theme.components.ThemeButton;

import javax.swing.*;

public class AddStudentFrame extends JDialog {
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JPanel dateField;

    public AddStudentFrame(JFrame parent) {
        super(parent, true);
        initComponents();
    }

    private void initComponents() {

        setTitle("Add Student");
        setContentPane(mainPanel);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        pack();
        setLocationRelativeTo(getParent());
        mainPanel.setBackground(UIManager.getColor("Panel.background").darker());
    }

    private void createUIComponents() {
        dateField = new DatePicker();
        addButton = new ThemeButton();
        cancelButton = new ThemeButton();
    }
}
