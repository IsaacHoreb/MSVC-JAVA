package com.microservice.jugadores.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jugadores")
public class jugadoresEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Long age;
    private String phone;

    @Column(name = "game_id")
    private Long gameId;

}
