package com.sakr.champion.participant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "champion_participant")
@Data
public class Participant {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mail")
	private String mail;

	@ManyToOne	(targetEntity = ParticipantsGroup.class,cascade = {CascadeType.ALL})
	@JoinColumn(name = "group_id")
	private ParticipantsGroup participantsGroup;

}
