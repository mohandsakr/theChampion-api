package com.sakr.champion.test.participant;

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
import com.sakr.champion.participant.controller.ParticipantController;
import com.sakr.champion.participant.dto.ParticipantRequest;
import com.sakr.champion.participant.service.ParticipantService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParticipantController.class)
class ParticipantControllerTest {

	@MockBean
	ParticipantService participantService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void addParticipantTest() throws JsonProcessingException, Exception {
		ParticipantRequest participantRequest = new ParticipantRequest();
		participantRequest.setMail("");
		participantRequest.setName("Moahnd Sakr");

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/participant/participate")
						.content(new ObjectMapper().writeValueAsString(participantRequest))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()

				);
	}

}
