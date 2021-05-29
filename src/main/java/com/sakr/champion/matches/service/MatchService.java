package com.sakr.champion.matches.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sakr.champion.matches.dto.MatchResultDto;
import com.sakr.champion.matches.entity.Match;

public interface MatchService {

	List<Match> getFirstRoundMatches();

	ResponseEntity<String> updateMatchWinner(MatchResultDto matchResultDto);

	ResponseEntity<String> closeRound(int roundId);
	
}
