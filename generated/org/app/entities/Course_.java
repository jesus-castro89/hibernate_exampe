package org.app.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

/**
 * Static metamodel for {@link org.app.entities.Course}
 **/
@StaticMetamodel(Course.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Course_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #courseId
	 **/
	public static final String COURSE_ID = "courseId";
	
	/**
	 * @see #courseName
	 **/
	public static final String COURSE_NAME = "courseName";
	
	/**
	 * @see #minimum
	 **/
	public static final String MINIMUM = "minimum";
	
	/**
	 * @see #maximum
	 **/
	public static final String MAXIMUM = "maximum";

	
	/**
	 * Static metamodel type for {@link org.app.entities.Course}
	 **/
	public static volatile EntityType<Course> class_;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Course#id}
	 **/
	public static volatile SingularAttribute<Course, UUID> id;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Course#courseId}
	 **/
	public static volatile SingularAttribute<Course, Long> courseId;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Course#courseName}
	 **/
	public static volatile SingularAttribute<Course, String> courseName;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Course#minimum}
	 **/
	public static volatile SingularAttribute<Course, Integer> minimum;
	
	/**
	 * Static metamodel for attribute {@link org.app.entities.Course#maximum}
	 **/
	public static volatile SingularAttribute<Course, Integer> maximum;

}

