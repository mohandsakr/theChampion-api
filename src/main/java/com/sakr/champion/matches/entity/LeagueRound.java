package com.sakr.champion.matches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "champion_round")
@Data
public class LeagueRound {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "round_start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date roundStartDate;

	@Column(name = "active")
	private boolean active;
	
}
