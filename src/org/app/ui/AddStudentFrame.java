package org.app.ui;

import com.github.lgooddatepicker.components.DatePicker;
import org.app.entities.Person;
import org.app.entities.Student;
import org.app.logic.StudentDAO;
import org.app.ui.theme.components.ThemeButton;
import org.app.ui.theme.components.ThemeInput;
import org.app.ui.theme.components.ThemeInputPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.function.Predicate;

public class AddStudentFrame extends JDialog {

    private JButton addButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JPanel dateField;
    private JPanel nameField;
    private JPanel lastNameField;
    private JPanel emailField;

    public AddStudentFrame(JFrame parent) {

        super(parent, true);
        initComponents();
        addButton.addActionListener(e -> addStudent());
        cancelButton.addActionListener(e -> dispose());
    }

    private void addStudent() {

        Predicate<LocalDate> isDate = o -> o != null && o.isBefore(LocalDate.now());
        String name = "";
        String lastName = "";
        String email = "";
        LocalDate dob = ((DatePicker) dateField).getDate();
        boolean error = false;
        var inputPanel = ((ThemeInputPanel<String>) nameField);
        inputPanel.validateInput();
        if (inputPanel.isValidField())
            name = inputPanel.getText();
        else
            error = true;

        inputPanel = ((ThemeInputPanel<String>) lastNameField);
        inputPanel.validateInput();
        if (inputPanel.isValidField())
            lastName = inputPanel.getText();
        else
            error = true;

        inputPanel = ((ThemeInputPanel<String>) emailField);
        inputPanel.validateInput();
        if (inputPanel.isValidField())
            email = inputPanel.getText();
        else
            error = true;

        if (!isDate.test(((DatePicker) dateField).getDate()))
            error = true;

        if (!error) {

            Person p = new Person();
            p.setFirstName(name);
            p.setLastName(lastName);
            p.setEmail(email);
            Student s = new Student();
            s.setPerson(p);
            s.setEnrollmentDate(dob);
            StudentDAO dao = new StudentDAO();
            dao.create(s);
            ((AppFrame) getParent()).loadStudentTable();
            dispose();
        }
        revalidate();
        repaint();
    }

    private void initComponents() {

        setTitle("Add Student");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationRelativeTo(getParent());
        mainPanel.setBackground(new Color(0xc8ddf2));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pack();
    }

    private void createUIComponents() {

        Predicate<String> isEmpty = s -> !s.isEmpty() && s.matches("^[A-Za-záéíóúñÁÉÍÓÚÑ]+$");
        Predicate<String> isEmail = s -> s.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        dateField = new DatePicker();
        addButton = new ThemeButton();
        cancelButton = new ThemeButton();
        nameField = new ThemeInputPanel<>("Nombre", "Juan...",
                "El nombre no puede estar vacío", isEmpty, this);
        lastNameField = new ThemeInputPanel<>("Apellido", "Pérez...",
                "El apellido no puede estar vacío", isEmpty, this);
        emailField = new ThemeInputPanel<>("Correo electrónico", "correo@dominio.com",
                "El formato de correo es invalido", isEmail, this);
    }
}
