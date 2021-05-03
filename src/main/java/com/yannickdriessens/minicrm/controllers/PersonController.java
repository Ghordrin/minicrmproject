package com.yannickdriessens.minicrm.controllers;

import com.yannickdriessens.minicrm.model.Community;
import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.service.PersonService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.time.LocalDate;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping("/persons/")
    public String getPersons(Model model){
        model.addAttribute("persons", personService.getPersonList());
        return "persons/persons";
    }

    @GetMapping(path = {"/persons/edit/", "persons/edit/{id}"})
    public String editPersonById(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        return "persons/editPerson";
    }

    @PostMapping(path = {"/persons/update/", "persons/update/{id}"})
    public String updatePersonById(@PathVariable("id") long id, HttpServletRequest request){
        String newDescription = request.getParameter("newCommunityDescription");
        Person person = personService.getPersonById(id);
        //getters here
        person.setFirstName(request.getParameter("firstName"));
        person.setLastName(request.getParameter("lastName"));
        person.setBirthDay(LocalDate.parse(request.getParameter("birthDay")));
        personService.updatePerson(person);
        return "redirect:/persons/";
    }

}
