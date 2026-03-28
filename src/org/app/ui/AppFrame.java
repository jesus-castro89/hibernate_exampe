package org.app.ui;

import org.app.entities.Student;
import org.app.logic.StudentDAO;
import org.app.ui.tablemodel.StudentTableModel;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

public class AppFrame extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JButton agregarAlumnoButton;
    private JTextField textField1;
    private JTable studenTable;
    private JButton button1;
    private AddStudentFrame addStudentFrame;

    public AppFrame() {
        initComponents();
        agregarAlumnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudentFrame.setVisible(true);
            }
        });
    }

    private void initComponents() {
        addStudentFrame = new AddStudentFrame(this);
        setContentPane(mainPanel);
        setTitle("My Application");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

    }

    private void updateTableModel() {

//        ArrayList<Student> students;
//        StudentDAO studentDAO = new StudentDAO();
//        students = studentDAO.findAll();
//        IO.println("Students: " + students.size());
//        StudentTableModel studentTableModel = new StudentTableModel(students);
//        studenTable.setModel(studentTableModel);
    }

    void main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppFrame();
            }
        });
    }

    private void createUIComponents() {
        StudentTableModel studentTableModel = new StudentTableModel();
        studenTable = new JTable(studentTableModel);
    }
}
