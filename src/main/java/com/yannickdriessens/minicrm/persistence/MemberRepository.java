package com.yannickdriessens.minicrm.persistence;


import com.yannickdriessens.minicrm.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, MemberID> {

    Optional<Member> findById(MemberID id);
}