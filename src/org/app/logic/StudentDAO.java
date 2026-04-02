package org.app.logic;

import org.app.entities.Student;
import org.app.entities.Student_;
import org.app.repositories.StudentRepository;
import org.app.repositories.StudentRepository_;
import org.app.util.App;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Order;
import org.hibernate.query.SortDirection;

import javax.swing.*;
import java.util.List;
import java.util.function.Predicate;

public class StudentDAO implements EntityDAO<Student> {

    private final StudentRepository repo;

    public StudentDAO() {
        this.repo = new StudentRepository_(App.getInstance().getSession());
    }

    @Override
    public Student create(Student entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public List<Student> findAll() {
        return repo.findAll(Order.asc(Student_.studentId));
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
