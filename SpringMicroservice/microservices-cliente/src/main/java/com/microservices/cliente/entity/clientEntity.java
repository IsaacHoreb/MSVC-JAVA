package com.microservices.cliente.entity;

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
@Table(name = "client")
public class clientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Long age;
    private String email;
    private String address;

    @Column(name = "product_id")
    private Long productId;

}
