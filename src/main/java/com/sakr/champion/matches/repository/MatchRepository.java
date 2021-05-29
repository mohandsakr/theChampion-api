package com.sakr.champion.matches.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakr.champion.matches.entity.Match;

 public interface MatchRepository extends JpaRepository<Match, Integer> {

	
}
