package com.sakr.champion.participant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakr.champion.participant.dto.ParticipantRequest;
import com.sakr.champion.participant.entity.Participant;
import com.sakr.champion.participant.service.ParticipantService;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@PostMapping("/participate")
	public ResponseEntity<String> addParticipant(@RequestBody ParticipantRequest participantRequest) {
		return participantService.participate(participantRequest);
	}

	@GetMapping("/get-participants")
	public ResponseEntity<List<Participant>> getAllParticipants() {
		return new ResponseEntity<>(participantService.getAllParticipants(), HttpStatus.OK);
	}

	@GetMapping("/make-groups")
	public ResponseEntity<Object> group(@RequestParam(name = "group-numbers") int numberOfGroups) {
		participantService.makeGroups(numberOfGroups);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}