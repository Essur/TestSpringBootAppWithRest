package uk.mk.essur.testspringbootappwithrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

}
