package uk.mk.essur.testspringbootappwithrest.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.mk.essur.testspringbootappwithrest.TestSpringBootAppWithRestApplication;
import uk.mk.essur.testspringbootappwithrest.entities.PersonDTO;
import uk.mk.essur.testspringbootappwithrest.service.PersonService;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSpringBootAppWithRestApplication.class)
@WebAppConfiguration
public class PersonControllerTest {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        PersonService service = webApplicationContext.getBean(PersonService.class);
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("TestFirstName");
        personDTO.setLastName("TestLastName");
        personDTO.setDateOfBirth(LocalDateTime.of(1995, Month.DECEMBER,12,14,2));
        service.addPerson(personDTO);
    }

    @Test
    public void testGetPersonByIdRequest() throws Exception {
        String uri = "/api/getPersonById/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        mvcResult.getResponse().getContentAsString();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}