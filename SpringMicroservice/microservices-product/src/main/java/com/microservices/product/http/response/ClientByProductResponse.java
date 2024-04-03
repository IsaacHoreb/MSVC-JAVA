//Creados despues del ClientDTOS
package com.microservices.product.http.response;

import com.microservices.product.dto.ClientDTOS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientByProductResponse {

    private String tipoProduct;
    private String modelo;
    private String procesador;
    private String ram;
    private String almacenamiento;
    private String bateria;
    private String pantalla;
    private String conectividad;
    private String sistemaOperativo;
    private String tipoSeguridad;
    private Long precio;
    private List<ClientDTOS> clientDTOSList;

    //Despues el nombre de esta clase va para nuestro servicio

}
