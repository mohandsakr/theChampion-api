package com.sakr.champion.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakr.champion.participant.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

	
	
}
