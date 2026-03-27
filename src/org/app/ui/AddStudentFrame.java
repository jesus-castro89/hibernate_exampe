package org.app.ui;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;

public class AddStudentFrame extends JDialog {
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JButton agregarButton;
    private JButton cancelarButton;
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
    }

    private void createUIComponents() {
        dateField = new DatePicker();
    }
}
