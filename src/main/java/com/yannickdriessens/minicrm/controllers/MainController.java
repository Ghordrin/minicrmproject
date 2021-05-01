package com.yannickdriessens.minicrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String getHomePage(){
        return "home/index";
    }

    @GetMapping("/communities")
    public String getCommunitiesPage(){
        return "communities/communities";

    }
}
