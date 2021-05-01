package com.yannickdriessens.minicrm.persistence;



import com.yannickdriessens.minicrm.model.PersonAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonAddressRepository extends CrudRepository<PersonAddress, PersonAddressID> {

    Optional<PersonAddress> findById(PersonAddressID id);

}