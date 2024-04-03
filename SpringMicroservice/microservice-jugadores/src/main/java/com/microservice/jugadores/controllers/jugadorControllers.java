package com.microservice.jugadores.controllers;

import com.microservice.jugadores.entity.jugadoresEntitys;
import com.microservice.jugadores.services.IJugadoresServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/jugadores")
public class jugadorControllers {

    @Autowired
    private IJugadoresServices services;

    @PostMapping("/create")
    public ResponseEntity<jugadoresEntitys> saveJugador(@RequestBody @Valid jugadoresEntitys jugadores) {
        return ResponseEntity.ok(services.guardarJugador(jugadores));
    }

    @GetMapping("/search/{idJugador}")
    public ResponseEntity<jugadoresEntitys> getJugadoresId(@PathVariable("idJugador") Long idJugador) {
        return ResponseEntity.ok(services.obtenerJugadorPorId(idJugador));
    }

    @PutMapping("/update/search/{idJugador}")
    public ResponseEntity<jugadoresEntitys> updateJugadorId(@PathVariable("idJugador") Long idJugador, @RequestBody @Valid jugadoresEntitys detalles) {
        return ResponseEntity.ok(services.actualizarJugadorPorId(idJugador, detalles));
    }

    @DeleteMapping("/delete/search/{idJugador}")
    public ResponseEntity<?> deleteJugadorId(@PathVariable("idJugador") Long idJugador) {
        services.eliminarJugadorPorId(idJugador);
        return ResponseEntity.ok("Jugador eliminado con éxito...");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<jugadoresEntitys>> findAllJugadores() {
        return ResponseEntity.ok(services.listarTodosJugadores());
    }

    //endPoint para comunicarse
    @GetMapping("/search-by-game/{idGame}")
    public ResponseEntity<?> findByIdGame(@PathVariable("idGame") Long idGame) {
        return ResponseEntity.ok(services.findByIdGame(idGame));
    }

}
