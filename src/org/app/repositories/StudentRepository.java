package org.app.repositories;

import org.app.entities.Student;
import org.hibernate.Session;
import org.hibernate.annotations.processing.Find;

import java.util.List;

public interface StudentRepository {

    Session session();

    @Find
    List<Student> findAll();
}
