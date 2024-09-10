package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Player;

public interface PlayerDao extends JpaRepository<Player,Integer>{

}
