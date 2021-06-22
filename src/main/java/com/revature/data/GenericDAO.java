package com.revature.data;

import java.util.List;


public interface GenericDAO <T> {
	// CRUD operations (create, read, update, delete)
	public T add(T t) throws Exception;
	public T getById(Integer id);
	public List<T> getAll();
	public void update(T t);
	public void delete(T t);
}
