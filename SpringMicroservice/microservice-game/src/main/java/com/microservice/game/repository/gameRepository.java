package com.microservice.game.repository;

import com.microservice.game.entity.gameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gameRepository extends JpaRepository<gameEntity, Long> {




}
