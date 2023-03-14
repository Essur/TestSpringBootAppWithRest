package uk.mk.essur.testspringbootappwithrest.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uk.mk.essur.testspringbootappwithrest.entities.PersonDTO;
import uk.mk.essur.testspringbootappwithrest.repositories.PersonRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public int getAgeOfHuman(PersonDTO personDTO){
        return LocalDateTime.now().getYear() - personDTO.getDateOfBirth().getYear();
    }
    public PersonDTO getPersonById(Long id){
        Optional<PersonDTO> person = personRepository.findById(id);
        if (person.isPresent()){
            return person.get();
        } else throw new RuntimeException("User not found");
    }

    public void addPerson(PersonDTO personDTO){
        personRepository.save(personDTO);
    }
}
