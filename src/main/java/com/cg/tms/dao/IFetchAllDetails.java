package com.cg.tms.dao;

import java.util.List;

/* This interface is written to provide other 
 * CRUD operation on other entities available.
 *  For example fetching the student details*/
public interface IFetchAllDetails<T> {
	public List<T> retrieveAll();

	public T retrieve(String id);
}
