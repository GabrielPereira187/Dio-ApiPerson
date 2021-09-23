package one.digitalinnovation.personapi.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person persontoSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(persontoSave);
        return MessageResponseDTO
        .builder()
        .message("Person created with the ID: " + savedPerson.getId())
        .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return  people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
     public PersonDTO findByID(Long ID) throws PersonNotFoundException{
        Optional <Person> optionalPerson = personRepository.findById(ID);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(ID);
        }
        return personMapper.toDTO(optionalPerson.get());
     }
     public void deletebyId(Long id) throws PersonNotFoundException{
        Optional <Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        else{
            personRepository.deleteById(id);
        }
       
     }
     
     public MessageResponseDTO updatebyId(Long id,PersonDTO personDTO) throws PersonNotFoundException{
        Person persontoUpdate = personMapper.toModel(personDTO);
        Optional <Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        Person savedPerson = personRepository.save(persontoUpdate);
        return MessageResponseDTO
        .builder()
        .message("Person created with the ID: " + savedPerson.getId())
        .build();
    }
}
