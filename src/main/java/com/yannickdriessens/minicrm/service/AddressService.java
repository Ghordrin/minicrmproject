package com.yannickdriessens.minicrm.service;

import com.yannickdriessens.minicrm.model.Address;
import com.yannickdriessens.minicrm.model.Person;
import com.yannickdriessens.minicrm.persistence.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

}
