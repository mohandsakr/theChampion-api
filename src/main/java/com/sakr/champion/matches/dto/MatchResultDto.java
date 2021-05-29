package com.sakr.champion.matches.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MatchResultDto implements Serializable {
	
	private static final long serialVersionUID = 2563521124448535240L;
	
	private int matchId;
	private int firstTeamScore;
	private int secondScore;
	
	 
}
