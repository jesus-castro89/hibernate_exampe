package org.app.ui;

import javax.swing.*;

public class TabExample extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JButton button1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button2;
    private JButton button3;

    public TabExample(){
        setTitle("Tab Example");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
