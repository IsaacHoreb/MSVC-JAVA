package com.microservice.jugadores.services;

import com.microservice.jugadores.entity.jugadoresEntitys;

import java.util.List;

public interface IJugadoresServices {

    jugadoresEntitys guardarJugador(jugadoresEntitys jugadores);

    jugadoresEntitys obtenerJugadorPorId(Long id);

    jugadoresEntitys actualizarJugadorPorId(Long id, jugadoresEntitys detalles);

    void eliminarJugadorPorId(Long id);

    List<jugadoresEntitys> listarTodosJugadores();

    List<jugadoresEntitys> findByIdGame(Long idGame);


}
