package com.microservice.jugadores.repository;

import com.microservice.jugadores.entity.jugadoresEntitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jugadoresRepository extends JpaRepository<jugadoresEntitys, Long> {

    @Query("SELECT j FROM jugadoresEntitys j WHERE j.gameId = :idGame")
    List<jugadoresEntitys> findAllJugador(Long idGame);

}
