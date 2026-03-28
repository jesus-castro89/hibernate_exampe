package org.app.logic;

import jakarta.persistence.NoResultException;
import org.app.entities.Person;
import org.app.repositories.PersonRepository;
import org.app.repositories.PersonRepository_;
import org.app.util.App;
import org.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Predicate;


public class PersonDAO implements EntityDAO<Person> {

    private final PersonRepository repo;

    public PersonDAO() {
        this.repo = new PersonRepository_(App.getInstance().getSession());
    }


    @Override
    public Person create(Person entity) {

        Person existing;
        try {
            existing = repo.findByEmail(entity.getEmail());
        } catch (NoResultException ex) {
            existing = null;
        }
        if (existing != null) {
            System.err.println("❌ Error: El correo '" + entity.getEmail() + "' ya existe en la base de datos.");
            return null;
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
            session.close();
            return entity;
        }
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public void delete(Person entity) {

    }

    @Override
    public List<Person> findAll() {

        return repo.findAll();
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
