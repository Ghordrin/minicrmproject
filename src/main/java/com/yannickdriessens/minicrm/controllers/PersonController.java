package com.yannickdriessens.minicrm.controllers;

import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping("/persons/")
    public String getPersons(Model model){
        model.addAttribute("persons", personService.getPersonList());
        return "persons/persons";
    }
}
