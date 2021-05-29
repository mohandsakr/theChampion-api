package com.sakr.champion.matches.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sakr.champion.matches.dto.MatchResultDto;
import com.sakr.champion.matches.entity.LeagueRound;
import com.sakr.champion.matches.entity.Match;
import com.sakr.champion.matches.repository.LeagueRoundRepository;
import com.sakr.champion.matches.repository.MatchRepository;
import com.sakr.champion.matches.service.MatchService;
import com.sakr.champion.participant.entity.ParticipantsGroup;
import com.sakr.champion.participant.repository.ParticipantsGroupRepository;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private LeagueRoundRepository leagueRoundRepository;

	@Autowired
	private ParticipantsGroupRepository participantsGroupRepository;

	@Override
	public List<Match> getFirstRoundMatches() {

		List<ParticipantsGroup> firstRoundGroups = participantsGroupRepository.findAll();
		List<Match> firstRoundMatches = new ArrayList<>();

		var match = new Match();

		var leagueRound = new LeagueRound();

		leagueRound.setActive(true);
		leagueRound.setRoundStartDate(new Date());

		for (var i = 0; i < firstRoundGroups.size(); i++) {

			if (i % 2 == 0) {
				match.setFirstTeam(firstRoundGroups.get(i));
			} else {
				match.setSecondTeam(firstRoundGroups.get(i));
				match.setLeagueRound(leagueRound);

				matchRepository.save(match);
				firstRoundMatches.add(match);
				match = new Match();
			}

		}

		return firstRoundMatches;
	}

	@Override
	public ResponseEntity<String> updateMatchWinner(MatchResultDto matchResultDto) {

		Optional<Match> neededMatch = matchRepository.findById(matchResultDto.getMatchId());
		var match = neededMatch.orElse(null);

		if (match != null) {
			match.getFirstTeam().setScore(matchResultDto.getFirstTeamScore());
			match.getSecondTeam().setScore(matchResultDto.getSecondScore());
			if (matchResultDto.getFirstTeamScore() > matchResultDto.getSecondScore()) {
				match.setWinner(match.getFirstTeam());
			} else {
				match.setWinner(match.getSecondTeam());
			}

			matchRepository.save(neededMatch.get());
		}
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> closeRound(int roundId) {
		Optional<LeagueRound> neededRound = leagueRoundRepository.findById(roundId);

		if (neededRound.isPresent()) {
			neededRound.get().setActive(false);
			leagueRoundRepository.save(neededRound.get());
		}

		return new ResponseEntity<>("Round Closed ", HttpStatus.OK);
	}

}
