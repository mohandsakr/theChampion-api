package com.sakr.champion.participant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "champion_group")
@Data
public class ParticipantsGroup {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "group_name")
	private String name;

	@Column(name = "score")
	private int score;

	@Column(name = "active")
	private boolean active;

}
