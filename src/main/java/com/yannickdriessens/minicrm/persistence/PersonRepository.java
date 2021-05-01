package com.yannickdriessens.minicrm.persistence;


import com.yannickdriessens.minicrm.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    List<Person> findAll();
    Person findById(long id);
}