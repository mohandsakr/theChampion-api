package com.sakr.champion.test.matches;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sakr.champion.matches.repository.LeagueRoundRepository;
import com.sakr.champion.matches.repository.MatchRepository;
import com.sakr.champion.matches.service.MatchService;
import com.sakr.champion.participant.repository.ParticipantsGroupRepository;

@SpringBootTest
class MatchServiceTest {

	@MockBean
	private MatchRepository matchRepository;

	@MockBean
	private LeagueRoundRepository leagueRoundRepository;

	@MockBean
	private ParticipantsGroupRepository participantsGroupRepository;
	@MockBean
	MatchService MatchService;

	@Test
	void getFirstRoundMatchesTest() {

		assertNotNull(MatchService.getFirstRoundMatches());

	}

	 

}
