package one.digitalinnovation.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {
	
private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@PostMapping
	public ResponseEntity<String> createPerson(Person person) {
		Person saved = personRepository.save(person);
		return new ResponseEntity<>("Created person with ID " + saved.getId(), HttpStatus.OK);
	}

}
