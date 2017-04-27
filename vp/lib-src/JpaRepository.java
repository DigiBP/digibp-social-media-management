package org.springframework.data.jpa.repository;

import java.io.Serializable;
import java.util.List;

public interface JpaRepository<T, ID extends Serializable> {
	<S extends T> S save(S var1);

	<S extends T> List<S> save(Iterable<S> var1);

	List<T> findAll();

	T findOne(ID var1);

	boolean exists(ID var1);

	long count();

	void delete(ID var1);

	void delete(T var1);

	void deleteAll();
}