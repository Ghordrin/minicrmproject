package com.yannickdriessens.minicrm.persistence;



import com.yannickdriessens.minicrm.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByStreet(String street);

    Address findById(long id);
}