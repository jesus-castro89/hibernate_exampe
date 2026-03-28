package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.Enrollment}
 **/
@StaticMetamodel(Enrollment.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Enrollment_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #enrollmentId
	 **/
	public static final String ENROLLMENT_ID = "enrollmentId";
	
	/**
	 * @see #grade
	 **/
	public static final String GRADE = "grade";
	
	/**
	 * @see #student
	 **/
	public static final String STUDENT = "student";
	
	/**
	 * @see #course
	 **/
	public static final String COURSE = "course";

	
	/**
	 * Static metamodel type for {@link org.app.entities.Enrollment}
	 **/
	public static volatile EntityType<Enrollment> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Enrollment#id}
	 **/
	public static volatile SingularAttribute<Enrollment, UUID> id;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Enrollment#enrollmentId}
	 **/
	public static volatile SingularAttribute<Enrollment, Long> enrollmentId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Enrollment#grade}
	 **/
	public static volatile SingularAttribute<Enrollment, Integer> grade;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Enrollment#student}
	 **/
	public static volatile SingularAttribute<Enrollment, Student> student;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Enrollment#course}
	 **/
	public static volatile SingularAttribute<Enrollment, Course> course;

}

