package com.revature.data;

import java.util.List;

import com.revature.beans.Cat;
import com.revature.beans.Person;
import com.revature.exceptions.CatAlreadyAdoptedException;

public interface CatDAO extends GenericDAO<Cat> {
	public Cat add(Cat c);
	public List<Cat> getAvailableCats();
	public void adoptCat(Person p, Cat c) throws CatAlreadyAdoptedException;
}
