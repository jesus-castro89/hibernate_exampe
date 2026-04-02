package org.app.repositories;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import java.util.List;
import static java.util.Objects.requireNonNull;
import org.app.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Order;
import org.hibernate.query.specification.SelectionSpecification;

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
	 * @see org.app.repositories.StudentRepository#findAll(Order)
	 **/
	@Override
	public List<Student> findAll(@Nonnull Order<Student> orderBy) {
		requireNonNull(orderBy, "Null orderBy");
		var _builder = session.getCriteriaBuilder();
		var _query = _builder.createQuery(Student.class);
		var _entity = _query.from(Student.class);
		_query.where(
		);
		var _spec = SelectionSpecification.create(_query);
		_spec.sort(orderBy);
		var _select = _spec.createQuery(session);
		return _select
				.getResultList();
	}

}

