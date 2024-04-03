package com.microservice.game.client;

import com.microservice.game.dto.jugadorDTOS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-jugadores", url = "localhost:8080/api/jugadores")
public interface jugadorClient {

    @GetMapping("/search-by-game/{idGame}")
    List<jugadorDTOS> findAllJugadorByGame(@PathVariable("idGame") Long idGame);

}
