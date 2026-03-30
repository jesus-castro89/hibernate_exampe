package org.app.ui;

import org.app.entities.Person;
import org.app.entities.Student;
import org.app.ui.tablemodel.StudentTableModel;
import org.app.ui.theme.components.ThemeButton;
import org.app.ui.theme.ThemeManager;
import org.app.ui.theme.Themes;
import org.app.ui.theme.components.ThemeTabbedPane;
import org.app.ui.theme.components.ThemeTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Objects;

public class AppFrame extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JButton addStudentBtn;
    private JTextField textField1;
    private JTable studentTable;
    private JButton button1;
    private JButton searchButton;
    private final AddStudentFrame addStudentFrame;

    public AppFrame() {
        initComponents();
        addStudentFrame = new AddStudentFrame(this);
        addStudentBtn.addActionListener(e -> addStudentFrame.setVisible(true));
    }

    private void initComponents() {

        setContentPane(mainPanel);
        setTitle("My Application");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        StudentTableModel model = (StudentTableModel) studentTable.getModel();
        Student student = new Student();
        student.setStudentId(1L);
        student.setEnrollmentDate(LocalDate.of(2026, 1, 1));
        Person person = new Person();
        person.setAge(20);
        person.setFirstName("John");
        person.setLastName("Doe");
        student.setPerson(person);
        model.addStudent(student);
        model.addStudent(student);
    }

    private void createUIComponents() throws URISyntaxException {

        ThemeManager.applyTheme(Themes.LIGHT);
        StudentTableModel studentTableModel = new StudentTableModel();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/search.png")));
        studentTable = new ThemeTable(studentTableModel);
        addStudentBtn = new ThemeButton();
        searchButton = new ThemeButton(icon);
        tabbedPane1 = new ThemeTabbedPane();
    }
}
