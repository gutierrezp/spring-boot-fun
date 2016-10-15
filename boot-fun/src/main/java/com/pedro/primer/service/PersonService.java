package com.pedro.primer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pedro.primer.dao.PersonDao;
import com.pedro.primer.model.Person;

@Service
public class PersonService {
	@Autowired
	@Qualifier("fakeData")
	private PersonDao personDao;
	
	public PersonService(PersonDao dao){
		this.personDao = dao;
	}
	
	public List<Person> getAllPersons(){
		return this.personDao.getAllPersons();
	}
	
	public Person getPerson (Person person){
		return this.personDao.getPerson(person);
	}
	
	public Person addPerson (Person person){
		return this.personDao.addPerson(person);
	}
	
	public Person updatePerson (Person person){
		return this.personDao.updatePerson(person);
	}
	
	public Person removePerson (Person person){
		return this.personDao.removePerson(person);
	}

}
