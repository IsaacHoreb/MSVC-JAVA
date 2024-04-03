package com.microservice.game.services.impl;

import com.microservice.game.client.jugadorClient;
import com.microservice.game.dto.jugadorDTOS;
import com.microservice.game.entity.gameEntity;
import com.microservice.game.http.response.JugadorByGameResponse;
import com.microservice.game.repository.gameRepository;
import com.microservice.game.services.IGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gameServicesImpl implements IGameServices {

    @Autowired
    private gameRepository repository;

    //Llamar a los datos del otro Msvc
    @Autowired
    private jugadorClient jugadorClient;

    @Override
    public gameEntity guardarJuego(gameEntity game) {
        return repository.save(game);
    }

    @Override
    public gameEntity actualizarJuegoPorId(Long id, gameEntity detalles) {

        gameEntity local = repository.findById(id)
                .orElse(null);

        gameEntity nuevo = null; //Guardar los datos nuevos

        if (local != null) {

            //Agregamos los detalles nuevos
            local.setName(detalles.getName());
            local.setType(detalles.getType());
            local.setType(detalles.getGenres());

            nuevo = repository.save(local);
            return nuevo;
        }

        return null;
    }

    @Override
    public gameEntity buscarJuegoPorId(Long id) {

        gameEntity local = repository.findById(id)
                .orElse(null);

        return local;
    }

    @Override
    public void eliminarJuegoPorId(Long id) {

        gameEntity local = repository.findById(id).orElseThrow();

        if (local != null) {
            repository.deleteById(id);
        }

    }

    @Override
    public List<gameEntity> listarTodosJuegos() {
        return repository.findAll();
    }

    @Override
    public JugadorByGameResponse findByJugadorByGame(Long idGame) {

        //Consultar game
        gameEntity game = repository.findById(idGame)
                .orElse(new gameEntity());

        //Consultar jugadores
        List<jugadorDTOS> jugadorDTOSList = jugadorClient.findAllJugadorByGame(idGame);

        //Devolver los datos deseados
        return JugadorByGameResponse.builder()
                .name(game.getName())
                .type(game.getType())
                .genres(game.getGenres())
                .jugadorDTOSList(jugadorDTOSList)
                .build();

    }

    //Despues agregarlo o usarlo en el controlador

}
