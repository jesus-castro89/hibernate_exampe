package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.Student}
 **/
@StaticMetamodel(Student.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Student_ {

	
	/**
	 * @see #personId
	 **/
	public static final String PERSON_ID = "personId";
	
	/**
	 * @see #studentId
	 **/
	public static final String STUDENT_ID = "studentId";
	
	/**
	 * @see #enrollmentDate
	 **/
	public static final String ENROLLMENT_DATE = "enrollmentDate";
	
	/**
	 * @see #person
	 **/
	public static final String PERSON = "person";

	
	/**
	 * Static metamodel type for {@link org.app.entities.Student}
	 **/
	public static volatile EntityType<Student> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Student#personId}
	 **/
	public static volatile SingularAttribute<Student, UUID> personId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Student#studentId}
	 **/
	public static volatile SingularAttribute<Student, Long> studentId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Student#enrollmentDate}
	 **/
	public static volatile SingularAttribute<Student, LocalDate> enrollmentDate;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Student#person}
	 **/
	public static volatile SingularAttribute<Student, Person> person;

}

