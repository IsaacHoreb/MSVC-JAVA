package com.microservices.product.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTOS {

    private String name;
    private String lastName;
    private Long age;
    private String email;
    private String address;
    private Long productId;

}
