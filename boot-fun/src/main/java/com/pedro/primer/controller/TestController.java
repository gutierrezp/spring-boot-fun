/**
 * 
 */
package com.pedro.primer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.primer.model.Person;
import com.pedro.primer.service.PersonService;

/**
 * @author VASSIT
 *
 */
@RestController
public class TestController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	String home() {
		return "Hello World! Let´s read the REST app";
	}

	@RequestMapping("/probando")
	String probando() {
		return "Maybe some day I will understand what the hell I´m doing...";
	}

	@RequestMapping(value = "/rest/personas", method = RequestMethod.GET)
	@CrossOrigin
	List<Person> persona() {
		List<Person> personList = this.personService.getAllPersons();
		return personList;
	}

	@RequestMapping(value = "/rest/personasPost", method = RequestMethod.POST)
	List<Person> personaPost() {
		List<Person> personList = this.personService.getAllPersons();
		return personList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") int id){
        Person person = new Person(id,"",0.0);
		return this.personService.getPerson(person);
    }
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Person person){
        //this.personService.updateStudent(person);
    }

	/**
	 * @return the personService
	 */
	public PersonService getPersonService() {
		return personService;
	}

	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
