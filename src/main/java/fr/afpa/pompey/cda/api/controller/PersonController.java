package fr.afpa.pompey.cda.api.controller;

import fr.afpa.pompey.cda.api.model.Person;
import fr.afpa.pompey.cda.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        Optional<Person> person = personService.getPerson(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }

    @PutMapping("/person/{id}")
    public Person updateEmployee(@PathVariable("id") int id, @RequestBody Person person) {
        Optional<Person> e = personService.getPerson(id);
        if(e.isPresent()) {
            Person current = e.get();

            String firstName = person.getFirstname();
            if(firstName != null) {
                current.setFirstname(firstName);
            }
            String lastName = person.getLastname();
            if(lastName != null) {
                current.setLastname(lastName);;
            }
            personService.savePerson(current);
            return current;
        } else {
            return null;
        }
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }
}
