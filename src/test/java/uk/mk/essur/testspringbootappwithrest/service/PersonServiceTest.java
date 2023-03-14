package uk.mk.essur.testspringbootappwithrest.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import uk.mk.essur.testspringbootappwithrest.entities.PersonDTO;
import uk.mk.essur.testspringbootappwithrest.repositories.PersonRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class PersonServiceTest {
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        personService = new PersonService(mock(PersonRepository.class));
    }

    @Test
    public void testGetAgeOfPerson(){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("TestFirstName");
        personDTO.setLastName("TestLastName");
        personDTO.setDateOfBirth(LocalDateTime.of(2000, Month.AUGUST,15,8,15));
        assertEquals(23,personService.getAgeOfHuman(personDTO));
    }
}