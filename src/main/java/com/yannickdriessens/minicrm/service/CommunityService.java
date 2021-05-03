package com.yannickdriessens.minicrm.service;

import com.yannickdriessens.minicrm.model.Community;
import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.persistence.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityService {

    @Autowired
    CommunityRepository communityRepository;

    public List<Community> getCommunityList(){
        return communityRepository.findAll();
    }

    public Community saveCommunityById(Community community){
        return communityRepository.save(community);
    }

    public Community addNewCommunity(String description){
        return new Community(description);
    }

    public Community getCommunityById(Long id){
        return communityRepository.findById(id).get();
    }

    public Community createNewCommunity(HttpServletRequest request){
        Community community = new Community();
        community.setDescription(request.getParameter("communityDescription"));
        communityRepository.save(community);
        return community;
    }

}
