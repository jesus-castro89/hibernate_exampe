package org.app.ui;

import javax.swing.*;

public class AddStudentFrame extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JPanel mainPanel;

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
}
