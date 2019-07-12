package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
