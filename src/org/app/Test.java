package org.app;

import org.app.entities.Person;
import org.app.entities.Student;
import org.app.logic.PersonDAO;
import org.app.logic.StudentDAO;
import org.app.util.App;
import org.app.util.DatabaseHelper;

import java.time.LocalDate;

public class Test {

    void main(){

        DatabaseHelper.createDatabaseIfNotExists("hibernate_db");
        DatabaseHelper.ensureAutoIncrementColumns();
        Student student = new Student();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("jhon.doe@dominio.com");
        person.setAge(20);
        student.setPerson(person);
        student.setEnrollmentDate(LocalDate.of(2026, 1, 25));
        StudentDAO studentDAO = new StudentDAO(App.getInstance().getSession());
        studentDAO.create(student);

    }
}
