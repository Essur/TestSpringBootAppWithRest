package uk.mk.essur.testspringbootappwithrest.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.mk.essur.testspringbootappwithrest.entities.PersonDTO;
import uk.mk.essur.testspringbootappwithrest.model.Person;
import uk.mk.essur.testspringbootappwithrest.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/getPersonById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPersonById(@PathVariable Long id){
        PersonDTO personDTOById = personService.getPersonById(id);
        int ageOfHuman = personService.getAgeOfHuman(personDTOById);
        return ResponseEntity.ok(new Person(personDTOById.getId(),
                personDTOById.getFirstName(),
                personDTOById.getLastName(),
                ageOfHuman));
    }

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody PersonDTO personDTO){
        PersonDTO person = new PersonDTO();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setDateOfBirth(personDTO.getDateOfBirth());
        personService.addPerson(person);
        return ResponseEntity.ok("Person successfully added");
    }
}
