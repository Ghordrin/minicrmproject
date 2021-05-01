package com.yannickdriessens.minicrm.persistence;


import com.yannickdriessens.minicrm.model.Community;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommunityRepository extends CrudRepository<Community, Long> {

    List<Community> findByDescription(String description);

    @Query(value = "select count(m) from Member m where m.Id = :id")
    int findAllPersonsInCommunity(@Param("id") long id);

    List<Community> findAll();

    Community findById(long id);
}

