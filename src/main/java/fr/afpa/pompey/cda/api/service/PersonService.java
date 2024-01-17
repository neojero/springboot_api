package fr.afpa.pompey.cda.api.service;

import fr.afpa.pompey.cda.api.model.Person;
import fr.afpa.pompey.cda.api.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
