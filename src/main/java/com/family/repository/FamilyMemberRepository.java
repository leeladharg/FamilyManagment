package com.family.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.family.model.FamilyMember;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Long> {

}