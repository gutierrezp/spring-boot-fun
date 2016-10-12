/**
 * 
 */
package com.pedro.primer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pedro.primer.model.Person;

/**
 * @author VASSIT
 *
 */
@Repository
@Qualifier("fakeData")
public class PersonDaoFakeImpl implements PersonDao {
	
	private static List<Person> persons;
	
    static {

        persons = new ArrayList();
        
        Person john = new Person(1,"John",1.99);
		Person hanna = new Person(2,"Hana",1.77);
		Person kelly = new Person(3,"Kelly",1.68);
		
		persons.add(john);
		persons.add(hanna);
		persons.add(kelly);
    }

	/* (non-Javadoc)
	 * @see com.pedro.primer.dao.PersonDao#getAllPersons()
	 */
	@Override
	public List<Person> getAllPersons() {
		return persons;
	}

	/* (non-Javadoc)
	 * @see com.pedro.primer.dao.PersonDao#getPerson(com.pedro.primer.model.Person)
	 */
	@Override
	public Person getPerson(Person person) {
		Person result = null;
		if(persons!=null){
			int location = persons.indexOf(person);
			if(location>=0){
				result = persons.get(location);
			}
		}
		return result;
	}

}
