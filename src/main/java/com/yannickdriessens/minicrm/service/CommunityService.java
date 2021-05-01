package com.yannickdriessens.minicrm.service;

import com.yannickdriessens.minicrm.model.Community;
import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.persistence.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Community addNewCommunity(String description){
        return new Community(description);
    }

    public Community getCommunityById(Long id){
        return communityRepository.findById(id).get();
    }

}