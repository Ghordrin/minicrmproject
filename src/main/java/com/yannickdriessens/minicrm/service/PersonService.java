package com.yannickdriessens.minicrm.service;

import com.yannickdriessens.minicrm.model.Address;
import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Person createNewPerson(Person person, Address address, HttpServletRequest request){
        String firstName = "";
        String lastName = "";
        LocalDate birthDay = null;
        try {
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            birthDay = LocalDate.parse(request.getParameter("birthDay"));

        }catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return new Person(firstName, lastName, birthDay);
    }


}
