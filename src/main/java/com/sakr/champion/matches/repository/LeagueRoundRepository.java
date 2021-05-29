package com.sakr.champion.matches.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakr.champion.matches.entity.LeagueRound;

public interface LeagueRoundRepository extends JpaRepository<LeagueRound, Integer> {

	
}
