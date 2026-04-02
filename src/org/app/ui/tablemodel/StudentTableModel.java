package org.app.ui.tablemodel;

import org.app.entities.Course;
import org.app.entities.Student;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private List<Student> students;
    private String[] columnNames = new String[]{"ID", "Nombre",
            "Apellido", "E-mail", "Fecha de Inscripción"};

    public StudentTableModel() {
        students = new ArrayList<>();
    }

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void clearStudents() {
        students.clear();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> student.getStudentId();
            case 1 -> student.getPerson().getFirstName();
            case 2 -> student.getPerson().getLastName();
            case 3 -> student.getPerson().getEmail();
            case 4 -> student.getEnrollmentDate();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
