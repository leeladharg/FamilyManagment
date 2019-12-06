package com.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.model.FamilyMember;
import com.family.model.GenericResponse;
import com.family.serivce.FamilyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FamilyController {
	
	@Autowired
	FamilyService familyService;

	
	@GetMapping("/getMemberById/{MID}")
	public ResponseEntity<FamilyMember> getMemberById(@PathVariable("MID") int mid) {
		log.info("getMemberById in Controller!....");
		FamilyMember res = familyService.getMemberById(mid);
		return new ResponseEntity<FamilyMember>(res, HttpStatus.OK);
	}
	
	@PostMapping(path = "/addMember",produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> addMember(@RequestBody FamilyMember req ) throws JsonProcessingException {
		log.info("addMember in Controller!....");
		ObjectMapper mapper = new ObjectMapper();
		final String json = mapper.writeValueAsString(req);
		log.info("Request json for addMember...."+ json);
		GenericResponse res  = familyService.addMember(req);
		log.info("Response...addMember in Controller!....");
		return new ResponseEntity<GenericResponse>(res,HttpStatus.OK);
	}
	
	@PostMapping(path = "/updateMember",produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> updateMember(@RequestBody FamilyMember req ) throws JsonProcessingException {
		log.info("updateMember in Controller!....");
		ObjectMapper mapper = new ObjectMapper();
		final String json = mapper.writeValueAsString(req);
		log.info("Request json for updateMember...."+ json);
		GenericResponse res  = familyService.updateMember(req);
		log.info("Response...updateMember in Controller!....");
		return new ResponseEntity<GenericResponse>(res,HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteMember",produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> deleteMember(@RequestBody FamilyMember req ) throws JsonProcessingException {
		log.info("deleteMember in Controller!....");
		ObjectMapper mapper = new ObjectMapper();
		final String json = mapper.writeValueAsString(req);
		log.info("Request json for deleteMember...."+ json);
		GenericResponse res  = familyService.deleteMember(req);
		log.info("Response...deleteMember in Controller!....");
		return new ResponseEntity<GenericResponse>(res,HttpStatus.OK);
	}
	@RequestMapping("/")
	public String ping() {
		String status = "Service is Up";

		return status;
	}

}
