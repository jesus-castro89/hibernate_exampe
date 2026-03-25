package org.app.logic;

import org.app.entities.Person;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.function.Predicate;


public class PersonDAO implements EntityDAO<Person> {

    @Override
    public Person create(Person entity) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public void delete(Person entity) {

    }

    @Override
    public Person findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public Person findBy(String fieldName, Predicate<Person> predicate) {
        return null;
    }

    @Override
    public List<Person> findByPredicate(Predicate<Person> predicate) {
        return List.of();
    }
}
