package org.app.repositories;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import java.util.List;
import org.app.entities.Student;
import org.hibernate.Session;

/**
 * Implements repository {@link org.app.repositories.StudentRepository}
 **/
@Generated("org.hibernate.processor.HibernateProcessor")
public class StudentRepository_ implements StudentRepository {


	
	protected final @Nonnull Session session;
	
	@Inject
	public StudentRepository_(@Nonnull Session session) {
		this.session = session;
	}
	
	@Override
	public @Nonnull Session session() {
		return session;
	}
	
	/**
	 * Find {@link Student}.
	 *
	 * @see org.app.repositories.StudentRepository#findAll()
	 **/
	@Override
	public List<Student> findAll() {
		var _builder = session.getCriteriaBuilder();
		var _query = _builder.createQuery(Student.class);
		var _entity = _query.from(Student.class);
		_query.where(
		);
		var _select = session.createSelectionQuery(_query);
		return _select
				.getResultList();
	}

}

