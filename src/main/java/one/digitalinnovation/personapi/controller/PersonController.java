package one.digitalinnovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
    
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
//cadastra pessoas no banco
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

//mostra as pessoas cadastradas
   

    //@DeleteMapping("/person/{id}")
    /*public MessageResponseDTO deletePerson(@PathVariable Long id){
        Person deletedPerson = personRepository.deleteById(id);
        return MessageResponseDTO.builder().message().build();
    }*/





    
}
