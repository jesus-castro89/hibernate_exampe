package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.Professor}
 **/
@StaticMetamodel(Professor.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Professor_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #professorId
	 **/
	public static final String PROFESSOR_ID = "professorId";
	
	/**
	 * @see #hours
	 **/
	public static final String HOURS = "hours";
	
	/**
	 * @see #person
	 **/
	public static final String PERSON = "person";

	
	/**
	 * Static metamodel type for {@link org.app.entities.Professor}
	 **/
	public static volatile EntityType<Professor> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Professor#id}
	 **/
	public static volatile SingularAttribute<Professor, UUID> id;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Professor#professorId}
	 **/
	public static volatile SingularAttribute<Professor, Long> professorId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Professor#hours}
	 **/
	public static volatile SingularAttribute<Professor, Integer> hours;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Professor#person}
	 **/
	public static volatile SingularAttribute<Professor, Person> person;

}

