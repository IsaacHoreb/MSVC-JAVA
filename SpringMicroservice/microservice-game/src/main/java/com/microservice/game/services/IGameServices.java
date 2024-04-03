package com.microservice.game.services;

import com.microservice.game.entity.gameEntity;
import com.microservice.game.http.response.JugadorByGameResponse;

import java.util.List;

public interface IGameServices {

    gameEntity guardarJuego(gameEntity game);

    gameEntity actualizarJuegoPorId(Long id, gameEntity detalles);

    gameEntity buscarJuegoPorId(Long id);

    void eliminarJuegoPorId(Long id);

    List<gameEntity> listarTodosJuegos();

    //Agregado despues del http response
    JugadorByGameResponse findByJugadorByGame(Long idGame);

}
