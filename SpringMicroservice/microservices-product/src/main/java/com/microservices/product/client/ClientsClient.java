package com.microservices.product.client;

import com.microservices.product.dto.ClientDTOS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-client", url = "localhost:9090/api/client")
public interface ClientsClient {

    @GetMapping("/search-by-product/{idProduct}")
    List<ClientDTOS> findAllClientByProduct(@PathVariable("idProduct") Long idProduct);

}
