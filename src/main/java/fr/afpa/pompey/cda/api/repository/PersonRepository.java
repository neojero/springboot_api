package fr.afpa.pompey.cda.api.repository;

import fr.afpa.pompey.cda.api.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
