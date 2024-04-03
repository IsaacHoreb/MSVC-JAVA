package com.microservice.game.http.response;

import com.microservice.game.dto.jugadorDTOS;
import com.microservice.game.entity.gameEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JugadorByGameResponse {

    private String name;
    private String type;
    private String genres;
    private List<jugadorDTOS> jugadorDTOSList;

    //Despues el nombre de esta clase va para nuestro servicio
}
