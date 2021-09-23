package one.digitalinnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
    
}
