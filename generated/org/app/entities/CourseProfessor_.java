package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.CourseProfessor}
 **/
@StaticMetamodel(CourseProfessor.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class CourseProfessor_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #courseProfessorId
	 **/
	public static final String COURSE_PROFESSOR_ID = "courseProfessorId";
	
	/**
	 * @see #professorId
	 **/
	public static final String PROFESSOR_ID = "professorId";
	
	/**
	 * @see #courseId
	 **/
	public static final String COURSE_ID = "courseId";
	
	/**
	 * @see #course
	 **/
	public static final String COURSE = "course";
	
	/**
	 * @see #professor
	 **/
	public static final String PROFESSOR = "professor";

	
	/**
	 * Static metamodel type for {@link org.app.entities.CourseProfessor}
	 **/
	public static volatile EntityType<CourseProfessor> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#id}
	 **/
	public static volatile SingularAttribute<CourseProfessor, UUID> id;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#courseProfessorId}
	 **/
	public static volatile SingularAttribute<CourseProfessor, Long> courseProfessorId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#professorId}
	 **/
	public static volatile SingularAttribute<CourseProfessor, Long> professorId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#courseId}
	 **/
	public static volatile SingularAttribute<CourseProfessor, Long> courseId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#course}
	 **/
	public static volatile SingularAttribute<CourseProfessor, Course> course;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.CourseProfessor#professor}
	 **/
	public static volatile SingularAttribute<CourseProfessor, Professor> professor;

}

