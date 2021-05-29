package com.sakr.champion.test.matches;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakr.champion.matches.controller.MatchContoller;
import com.sakr.champion.matches.dto.MatchResultDto;
import com.sakr.champion.matches.service.MatchService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MatchContoller.class)
class MatchControllerTest {

	@MockBean
	MatchService matchService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void getFirstRoundMatches() throws JsonProcessingException, Exception {

		this.mockMvc.perform(get("/matches/first-round-matches")).andExpect(status().isOk());

	}

	@Test
	void updateMatchWinnerTest() throws JsonProcessingException, Exception {
		MatchResultDto matchResultDto = new MatchResultDto();
		matchResultDto.setMatchId(2);
		matchResultDto.setFirstTeamScore(50);
		matchResultDto.setSecondScore(100);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/matches/update-match-result")
						.content(new ObjectMapper().writeValueAsString(matchResultDto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()

				);
	}

	@Test
	void closeRoundTest() throws JsonProcessingException, Exception {
		this.mockMvc.perform(get("/matches/close-round?round-id=1")).andExpect(status().isOk());

	}

}
