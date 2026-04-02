package org.app.ui;

import com.github.lgooddatepicker.components.DatePicker;
import org.app.entities.Person;
import org.app.entities.Student;
import org.app.logic.StudentDAO;
import org.app.ui.theme.components.ThemeButton;
import org.app.ui.theme.components.ThemeInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.function.Predicate;

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
        addButton.addActionListener(e -> addStudent());
        cancelButton.addActionListener(e -> dispose());
    }

    private void addStudent() {
        IO.println("Adding student...");
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isEmail = s -> s.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        Predicate<LocalDate> isDate = o -> o != null && o.isBefore(LocalDate.now());
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        LocalDate dob = ((DatePicker) dateField).getDate();
        String error = "";
        if (isEmpty.test(name)) {
            ((ThemeInput) nameField).setErrorMessage("El nombre no puede estar vacío");
            error += "El nombre no puede estar vacío\n";
            nameField.revalidate();
            nameField.repaint();
        }
        if (isEmpty.test(lastName)) {
            ((ThemeInput) lastNameField).setErrorMessage("El nombre no puede estar vacío");
            error += "El apellido no puede estar vacío\n";
            lastNameField.revalidate();
            lastNameField.repaint();
        }
        if (!isEmail.test(email)) {
            ((ThemeInput) emailField).setErrorMessage("El correo no es válido");
            error += "El correo no es válido\n";
            emailField.revalidate();
            emailField.repaint();
        }
        if (!isDate.test(((DatePicker) dateField).getDate()))
            error += "La fecha de inscripción debe ser previa a la actual\n";
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(this, error);
        } else {
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
    }

    private void initComponents() {

        setTitle("Add Student");
        setContentPane(mainPanel);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        pack();
        setLocationRelativeTo(getParent());
        mainPanel.setBackground(new Color(0xc8ddf2));
    }

    private void createUIComponents() {
        dateField = new DatePicker();
        addButton = new ThemeButton();
        cancelButton = new ThemeButton();
        nameField = new ThemeInput();
        lastNameField = new ThemeInput();
        emailField = new ThemeInput();
    }
}
