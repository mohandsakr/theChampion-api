package com.sakr.champion.matches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakr.champion.matches.dto.MatchResultDto;
import com.sakr.champion.matches.entity.Match;
import com.sakr.champion.matches.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchContoller {

	@Autowired
	private MatchService matchService;

	@GetMapping("/first-round-matches")
	public List<Match> getFirstRoundMatches() {
		return matchService.getFirstRoundMatches();

	}

	@PostMapping("/update-match-result")
	public ResponseEntity<String> updateMatchWinner(@RequestBody MatchResultDto matchResultDto) {
		return matchService.updateMatchWinner(matchResultDto);

	}
	
	@GetMapping("/close-round")
	public ResponseEntity<String> closeRound(@RequestParam(name = "round-id") int roundId) {
		return matchService.closeRound(roundId);
	}

}
