package org.app.repositories;

import org.app.entities.Person;
import org.hibernate.Session;
import org.hibernate.annotations.processing.Find;

import java.util.List;
import java.util.UUID;

public interface PersonRepository {

    Session session();

    @Find
    List<Person> findAll();

    @Find
    Person findById(UUID id);

    @Find
    Person findByEmail(String email);
}
