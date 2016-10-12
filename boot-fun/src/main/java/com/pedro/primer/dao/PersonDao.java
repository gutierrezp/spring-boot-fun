package com.pedro.primer.dao;

import java.util.List;

import com.pedro.primer.model.Person;

public interface PersonDao {
	
	public abstract List<Person> getAllPersons();
	
	public abstract Person getPerson (Person person);

}
