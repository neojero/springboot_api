package fr.afpa.pompey.cda.api;

import fr.afpa.pompey.cda.api.controller.PersonController;
import fr.afpa.pompey.cda.api.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;
    
    @Test
    public void getPersonsTest() throws Exception {
        mockMvc.perform(get("/persons")).andExpect(status().isOk());
    }
}
