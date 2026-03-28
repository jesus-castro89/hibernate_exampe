package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.Person}
 **/
@StaticMetamodel(Person.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Person_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #personId
	 **/
	public static final String PERSON_ID = "personId";
	
	/**
	 * @see #firstName
	 **/
	public static final String FIRST_NAME = "firstName";
	
	/**
	 * @see #lastName
	 **/
	public static final String LAST_NAME = "lastName";
	
	/**
	 * @see #email
	 **/
	public static final String EMAIL = "email";
	
	/**
	 * @see #age
	 **/
	public static final String AGE = "age";
	
	/**
	 * @see #student
	 **/
	public static final String STUDENT = "student";
	
	/**
	 * @see #teacher
	 **/
	public static final String TEACHER = "teacher";

	
	/**
	 * Static metamodel type for {@link org.app.entities.Person}
	 **/
	public static volatile EntityType<Person> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#id}
	 **/
	public static volatile SingularAttribute<Person, UUID> id;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#personId}
	 **/
	public static volatile SingularAttribute<Person, Long> personId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#firstName}
	 **/
	public static volatile SingularAttribute<Person, String> firstName;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#lastName}
	 **/
	public static volatile SingularAttribute<Person, String> lastName;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#email}
	 **/
	public static volatile SingularAttribute<Person, String> email;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#age}
	 **/
	public static volatile SingularAttribute<Person, Integer> age;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#student}
	 **/
	public static volatile SingularAttribute<Person, Student> student;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Person#teacher}
	 **/
	public static volatile SingularAttribute<Person, Professor> teacher;

}

