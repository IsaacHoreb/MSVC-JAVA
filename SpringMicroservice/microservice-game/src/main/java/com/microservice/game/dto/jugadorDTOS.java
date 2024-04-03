package com.microservice.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class jugadorDTOS {

    private String name;
    private String lastName;
    private Long age;
    private String phone;
    private Long gameId;

}
