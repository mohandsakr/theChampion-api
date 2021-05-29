package com.sakr.champion.matches.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sakr.champion.participant.entity.ParticipantsGroup;

import lombok.Data;

@Entity
@Table(name = "champion_match")
@Data
public class Match {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(targetEntity = ParticipantsGroup.class,cascade = {CascadeType.ALL})
	@JoinColumn(name = "first_team_id")
	private ParticipantsGroup firstTeam;

	@OneToOne(targetEntity = ParticipantsGroup.class,cascade = {CascadeType.ALL})
	@JoinColumn(name = "second_team_id")
	private ParticipantsGroup secondTeam;

	@ManyToOne(targetEntity = LeagueRound.class,cascade = {CascadeType.ALL})
	@JoinColumn(name = "round_id")
	private LeagueRound leagueRound;

	@OneToOne(targetEntity = ParticipantsGroup.class,cascade = {CascadeType.ALL})
	@JoinColumn(name = "winner_id")
	private ParticipantsGroup winner;

}
