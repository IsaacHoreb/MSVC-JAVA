package com.microservices.product.entity;

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
@Table(name = "product")
public class productEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "tipo_product")
    private String tipoProduct;
    private String modelo;
    private String procesador;
    private String ram;
    private String almacenamiento;
    private String bateria;
    private String pantalla;
    private String conectividad;

    @Column(name = "sistema_operativo")
    private String sistemaOperativo;

    @Column(name = "tipo_seguridad")
    private String tipoSeguridad;
    private Long precio;

}
