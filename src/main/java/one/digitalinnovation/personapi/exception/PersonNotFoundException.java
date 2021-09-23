package one.digitalinnovation.personapi.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Long id){
        super("Person not found with ID: " + id);
    }
    
}
