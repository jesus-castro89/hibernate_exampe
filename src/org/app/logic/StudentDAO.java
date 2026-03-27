package org.app.logic;

import org.app.entities.Student;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentDAO implements EntityDAO<Student> {

    @Override
    public Student create(Student entity) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public ArrayList<Student> findAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        // Recuperamos todos los estudiantes con su información de persona asociada
        List<Student> students;
        students = session.createNativeQuery(
                "SELECT s.* " +
                        "FROM student s " +
                        "JOIN person p ON s.id = p.id", Student.class)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return new ArrayList<>(students);
    }

    @Override
    public Student findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public Student findBy(String fieldName, Predicate<Student> predicate) {
        return null;
    }

    @Override
    public List<Student> findByPredicate(Predicate<Student> predicate) {
        return List.of();
    }
}
