package com.microservice.game.controllers;

import com.microservice.game.entity.gameEntity;
import com.microservice.game.services.IGameServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/game")
public class gameControllers {

    @Autowired
    private IGameServices gameServices;

    @PostMapping("/create")
    public ResponseEntity<gameEntity> saveGame(@RequestBody @Valid gameEntity game) {
        return ResponseEntity.ok(gameServices.guardarJuego(game));
    }

    @GetMapping("/search/{idGame}")
    public ResponseEntity<gameEntity> getGame(@PathVariable("idGame") Long idGame) {
        return ResponseEntity.ok(gameServices.buscarJuegoPorId(idGame));
    }

    @PutMapping("/update/search/{idGame}")
    public ResponseEntity<gameEntity> updateGameId(@PathVariable("idGame") Long idGame, @RequestBody @Valid gameEntity detalles) {
        return ResponseEntity.ok(gameServices.actualizarJuegoPorId(idGame, detalles));
    }

    @DeleteMapping("/delete/search/{idGame}")
    public ResponseEntity<String> deleteGameId(@PathVariable("idGame") Long id) {
        gameServices.eliminarJuegoPorId(id);
        return ResponseEntity.ok("Juego eliminado exitosamente...");
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAllGame() {
        return ResponseEntity.ok(gameServices.listarTodosJuegos());
    }

    @GetMapping("/search-jugador/{idGame}")
    public ResponseEntity<?> findJugadorByGame(@PathVariable("idGame") Long idGame) {
        return ResponseEntity.ok(gameServices.findByJugadorByGame(idGame));
    }

}
