package com.sakr.champion.participant.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sakr.champion.participant.dto.ParticipantRequest;
import com.sakr.champion.participant.entity.Participant;
import com.sakr.champion.participant.entity.ParticipantsGroup;
import com.sakr.champion.participant.repository.ParticipantRepository;
import com.sakr.champion.participant.repository.ParticipantsGroupRepository;
import com.sakr.champion.participant.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private ParticipantsGroupRepository participantsGroupRepository;

	@Override
	public ResponseEntity<String> participate(ParticipantRequest participantRequest) {

		List<Participant> currentParticipants = participantRepository.findAll();

		if (currentParticipants.size() < 12) {
			var participant = new Participant();
			participant.setName(participantRequest.getName());
			participant.setMail(participantRequest.getMail());
			participantRepository.save(participant);

			return new ResponseEntity<>("Added", HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>("Paricipants are maximixez", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public List<Participant> getAllParticipants() {
		return participantRepository.findAll();

	}

	@Override
	public void makeGroups(int numberOfGroups) {
		addParticipantsToGroup(numberOfGroups);

	}

	public ParticipantsGroup construtGroup(int groupNumber) {

		var participantsGroup = new ParticipantsGroup();
		participantsGroup.setName("Group Number " + groupNumber);
		participantsGroup.setScore(0);
		participantsGroup.setActive(true);

		return participantsGroup;
	}

	public void addParticipantsToGroup(int numberOfGroups) {

		List<Participant> currentParticipants = participantRepository.findAll();
		Collections.shuffle(currentParticipants);
		int currentParticipantsNumber = currentParticipants.size();
		int numberPerGroup = currentParticipantsNumber / numberOfGroups;
		var groupNumberCouter = 1;
		var participantsGroup = new ParticipantsGroup();

		for (var currentParticipantsNumberCounter = 0; currentParticipantsNumberCounter < currentParticipantsNumber; currentParticipantsNumberCounter++) {

			if (currentParticipantsNumberCounter % numberPerGroup == 0) {

				participantsGroup = construtGroup(groupNumberCouter);
				participantsGroupRepository.save(participantsGroup);
				++groupNumberCouter;
			}

			currentParticipants.get(currentParticipantsNumberCounter).setParticipantsGroup(participantsGroup);
			participantRepository.save(currentParticipants.get(currentParticipantsNumberCounter));
		}

	}

}
