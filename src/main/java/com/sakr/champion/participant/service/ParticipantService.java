package com.sakr.champion.participant.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sakr.champion.participant.dto.ParticipantRequest;
import com.sakr.champion.participant.entity.Participant;

public interface ParticipantService {
	
	ResponseEntity<String> participate(ParticipantRequest participantRequest);
	
	List <Participant> getAllParticipants();
	
	void makeGroups(int numberOfGroups);
	
}
