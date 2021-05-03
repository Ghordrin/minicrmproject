package com.yannickdriessens.minicrm.controllers;

import com.yannickdriessens.minicrm.model.Community;
import com.yannickdriessens.minicrm.persistence.CommunityRepository;
import com.yannickdriessens.minicrm.persistence.MemberID;
import com.yannickdriessens.minicrm.persistence.MemberRepository;
import com.yannickdriessens.minicrm.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(path = {"/communities/edit/", "communities/edit/{id}"})
    public String editCommunityById(@PathVariable("id") long id, Model model){
        model.addAttribute("community", communityService.getCommunityById(id));
        return "communities/editCommunity";
    }

    @GetMapping("/communities/")
    public String getAllCommunities(Model model){
        model.addAttribute("communities", communityService.getCommunityList());
        return "communities/communities";
    }

    @PostMapping(path = {"/communities/update/", "communities/update/{id}"})
    public String updateCommunityById(@PathVariable("id") long id, HttpServletRequest request){
        String newDescription = request.getParameter("newCommunityDescription");
        Community community = communityService.getCommunityById(id);
        community.setDescription(newDescription);
        communityService.saveCommunityById(community);
        return "redirect:/communities/";
    }



}
