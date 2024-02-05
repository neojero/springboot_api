package fr.afpa.pompey.cda.api;

import fr.afpa.pompey.cda.api.controller.PersonController;
import fr.afpa.pompey.cda.api.service.PersonService;
import fr.afpa.pompey.cda.api.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class PersonControllerMockTest {

    /**
     * Dans ce test Mockito, nous utilisons @Mock pour créer un mock de PersonService
     * et @InjectMocks pour injecter ce mock dans PersonController.
     * Ensuite, nous configurons le comportement du mock pour la méthode getPerson afin qu'elle renvoie
     * une Optional contenant une personne fictive lorsque l'ID spécifié est 1.
     * Ensuite, nous appelons la méthode getPerson de PersonController avec l'ID 1
     * et vérifions que la réponse est correcte.
    */

    @Mock
    private PersonService personService;
    @InjectMocks
    private PersonController personController;
    @Test
    public void testGetPersonByIdTest() throws Exception {
        // Création d'une personne fictive pour le test
        Person person = new Person();
        person.setId(1);
        person.setFirstname("John");
        person.setLastname("Doe");

        // Configuration du comportement du mock pour la méthode getPerson
        when(personService.getPerson(1)).thenReturn(Optional.of(person));

        // Appel de la méthode à tester
        Optional<Person> responseEntity = Optional.ofNullable(personController.getPerson(1));

        assertThat(responseEntity.isPresent()).isTrue();
        assertThat(responseEntity.get().getId()).isEqualTo(1);
        assertThat(responseEntity.get().getFirstname()).isEqualTo("John");
        assertThat(responseEntity.get().getLastname()).isEqualTo("Doe");
    }
}
