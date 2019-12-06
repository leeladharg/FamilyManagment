package com.family.serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.model.FamilyMember;
import com.family.model.GenericResponse;
import com.family.repository.FamilyMemberRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FamilyService {

	@Autowired
	FamilyMemberRepository familyMemberRepo;
	
	public FamilyMember getMemberById(int id) {
		log.info("getMemberById in service calling repo....");
		Optional<FamilyMember> obj1 =familyMemberRepo.findById(id);
		log.info("Got res from repo....");
		return obj1.get();
	}
	
	public GenericResponse addMember(FamilyMember member) {
		log.info("addMember in Service!....");
		GenericResponse res = new GenericResponse();
		familyMemberRepo.save(member);
		res.setStatus("Sucess");
		res.setStatusMessage("Sucessfuly added memeber");
		log.info("addMember in Got res from repo!....");
		return res;
	}
	
	public GenericResponse updateMember(FamilyMember member) {
		log.info("upateMember in Service!....");
		GenericResponse res = new GenericResponse();
		
		Optional<FamilyMember> opt =familyMemberRepo.findById(member.getMid());
		log.info("Got res from repo....");
		FamilyMember obj=opt.get();
		obj.setFirstName(member.getFirstName());
		familyMemberRepo.save(obj);
		res.setStatus("Sucess");
		res.setStatusMessage("Sucessfuly updated memeber");
		log.info("updateMember in Got res from repo!....");
		return res;
	}
	
	public GenericResponse deleteMember(FamilyMember member) {
		log.info("deleteMember in Service!....");
		GenericResponse res = new GenericResponse();
		familyMemberRepo.delete(member);
		res.setStatus("Sucess");
		res.setStatusMessage("Sucessfuly delete memeber");
		log.info("deleteMember in Got res from repo!....");
		return res;
	}
}
