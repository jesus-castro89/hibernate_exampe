package org.app.repositories;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.UUID;
import org.app.entities.Person;
import org.app.entities.Person_;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

/**
 * Implements repository {@link org.app.repositories.PersonRepository}
 **/
@Generated("org.hibernate.processor.HibernateProcessor")
public class PersonRepository_ implements PersonRepository {


	
	protected final @Nonnull Session session;
	
	@Inject
	public PersonRepository_(@Nonnull Session session) {
		this.session = session;
	}
	
	@Override
	public @Nonnull Session session() {
		return session;
	}
	
	/**
	 * Find {@link Person}.
	 *
	 * @see org.app.repositories.PersonRepository#findAll()
	 **/
	@Override
	public List<Person> findAll() {
		var _builder = session.getCriteriaBuilder();
		var _query = _builder.createQuery(Person.class);
		var _entity = _query.from(Person.class);
		_query.where(
		);
		var _select = session.createSelectionQuery(_query);
		return _select
				.getResultList();
	}
	
	/**
	 * Find {@link Person} by {@link Person#id id}.
	 *
	 * @see org.app.repositories.PersonRepository#findById(UUID)
	 **/
	@Override
	public Person findById(@Nonnull UUID id) {
		requireNonNull(id, "Null id");
		var _result = session.find(Person.class, id);
		if (_result == null) throw new ObjectNotFoundException((Object) id, "org.app.entities.Person");
		return _result;
	}
	
	/**
	 * Find {@link Person} by {@link Person#email email}.
	 *
	 * @see org.app.repositories.PersonRepository#findByEmail(String)
	 **/
	@Override
	public Person findByEmail(String email) {
		var _builder = session.getCriteriaBuilder();
		var _query = _builder.createQuery(Person.class);
		var _entity = _query.from(Person.class);
		_query.where(
				email==null
					? _entity.get(Person_.email).isNull()
					: _builder.equal(_entity.get(Person_.email), email)
		);
		var _select = session.createSelectionQuery(_query);
		return _select
				.getSingleResult();
	}

}

