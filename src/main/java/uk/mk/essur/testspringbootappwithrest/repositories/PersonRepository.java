package uk.mk.essur.testspringbootappwithrest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.mk.essur.testspringbootappwithrest.entities.PersonDTO;


@Repository
public interface PersonRepository extends CrudRepository<PersonDTO, Long> {
}