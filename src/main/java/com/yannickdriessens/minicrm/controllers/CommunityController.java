package com.yannickdriessens.minicrm.controllers;

import com.yannickdriessens.minicrm.model.Community;
import com.yannickdriessens.minicrm.persistence.CommunityRepository;
import com.yannickdriessens.minicrm.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    CommunityRepository communityRepository;

    @GetMapping(path = {"/communities/edit/", "communities/edit/{id}"})
    public String editCommunityById(@PathVariable("id") long id){
        return "/communities/editCommunity/";
    }

    @GetMapping("/communities/")
    public String getAllCommunities(Model model){
        model.addAttribute("communities", communityService.getCommunityList());
        return "communities/communities";
    }

    @GetMapping("communities/{id}/all")
    public String getAllMembersInCommunity(@PathVariable("id") long id, Model model){
        model.addAttribute("amountOfPersons", communityRepository.findAllPersonsInCommunity(id));
        return "communities/communities";
    }


}
