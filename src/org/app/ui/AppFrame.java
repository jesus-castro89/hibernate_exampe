package org.app.ui;

import org.app.entities.Student;
import org.app.logic.StudentDAO;
import org.app.ui.tablemodel.StudentTableModel;
import org.app.ui.theme.components.ThemeButton;
import org.app.ui.theme.ThemeManager;
import org.app.ui.theme.Themes;
import org.app.ui.theme.components.ThemeInput;
import org.app.ui.theme.components.ThemeTabbedPane;
import org.app.ui.theme.components.ThemeTable;
import org.app.util.App;
import org.app.util.DatabaseHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.function.Predicate;

public class AppFrame extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JButton addStudentBtn;
    private JTextField searchField;
    private JTable studentTable;
    private JButton button1;
    private JButton searchButton;
    private JTextField textField1;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private AddStudentFrame addStudentFrame;
    private final Semaphore dbSemaphore = new Semaphore(1, true);
    private List<Student> students;
    private StudentTableModel studentTableModel;
    private Timer timer;
    private boolean update = false;

    public AppFrame() {
        initComponents();
        timer = new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (update) {
                    studentTableModel = (StudentTableModel) studentTable.getModel();
                    studentTableModel.clearStudents();
                    students.forEach(studentTableModel::addStudent);
                    studentTable.revalidate();
                    studentTable.repaint();
                    update = false;
                }
            }
        });
        timer.start();
        initDataBaseConnection();
        loadStudentTable();
        addStudentBtn.addActionListener(e -> {
            addStudentFrame = new AddStudentFrame(this);
            addStudentFrame.setVisible(true);
        });
    }

    private void initComponents() {

        setContentPane(mainPanel);
        setTitle("My Application");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void initDataBaseConnection() {

        Thread thread = new Thread(() -> {
            try {
                dbSemaphore.acquire();
                DatabaseHelper.createDatabaseIfNotExists("hibernate_db");
                DatabaseHelper.ensureAutoIncrementColumns();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                dbSemaphore.release();
            }
        });
        thread.start();
    }

    public void loadStudentTable() {
        new Thread(() -> {
            try {
                dbSemaphore.acquire();
                IO.println("Cargando datos de estudiantes...");
                StudentDAO studentDAO = new StudentDAO();
                students = studentDAO.findAll();
                update = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dbSemaphore.release();
            }
        }).start();
    }

    private void createUIComponents() throws URISyntaxException {

        ThemeManager.applyTheme(Themes.LIGHT);
        StudentTableModel studentTableModel = new StudentTableModel();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/search.png")));
        studentTable = new ThemeTable(studentTableModel);
        addStudentBtn = new ThemeButton();
        editStudentBtn = new ThemeButton();
        deleteStudentBtn = new ThemeButton();
        searchButton = new ThemeButton(icon);
        tabbedPane1 = new ThemeTabbedPane();
        Predicate<String> searchFieldFilter = s -> s.matches(".*");
        Predicate<String> lastNameFilter = s -> s.matches(".*");
        searchField = new ThemeInput<>("Busqueda", "Nombre...", "", searchFieldFilter);
        textField1 = new ThemeInput<>("E","Ejemplo", "", lastNameFilter);
    }
}
