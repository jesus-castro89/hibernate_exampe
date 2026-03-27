package org.app.logic;

import org.app.entities.Person;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PersonDAO implements EntityDAO<Person> {

    @Override
    public Person create(Person entity) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        // Comprobamos si existe el correo previo a la inserción
        String email = entity.getEmail();
        Person existingPerson = session.createQuery("FROM Person WHERE email = :email", Person.class)
                .setParameter("email", email)
                .uniqueResult();
        IO.println("🔍 Verificando existencia del correo: " + email);
        IO.println(existingPerson);
        if (existingPerson == null) {
            session.persist(entity);
        } else {
            System.err.println("❌ Error: El correo '" + email + "' ya existe en la base de datos.");
        }
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
    public ArrayList<Person> findAll() {
        return null;
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
