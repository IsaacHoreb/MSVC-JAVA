package com.microservices.cliente.controller;

import com.microservices.cliente.entity.clientEntity;
import com.microservices.cliente.services.IClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/client")
public class clientControllers {

    @Autowired
    private IClientServices clientServices;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<clientEntity> save(@RequestBody @Valid clientEntity detalles) {
        return ResponseEntity.ok(clientServices.guardarCliente(detalles));
    }

    @GetMapping("/search/{idClient}")
    public ResponseEntity<clientEntity> getClientId(@PathVariable("idClient") Long idClient) {
        return ResponseEntity.ok(clientServices.obtenerClientPorId(idClient));
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAllClient() {
        return ResponseEntity.ok(clientServices.listarTodoClientes());
    }

    @PutMapping("/update/search/{idClient}")
    public ResponseEntity<clientEntity> updateClientId(@PathVariable("idClient") Long idClient, @RequestBody @Valid clientEntity detalles) {
        return ResponseEntity.ok(clientServices.actualizarClientPorId(idClient, detalles));
    }

    @DeleteMapping("/delete/search/{idClient}")
    public ResponseEntity<?> deleteClientId(@PathVariable("idClient") Long idClient) {
        clientServices.eliminarClientPorId(idClient);
        return ResponseEntity.ok("Cliente eliminado con éxito");
    }

    //endPoint para comunicarse
    @GetMapping("/search-by-product/{idProduct}")
    public ResponseEntity<?> findByIdProduct(@PathVariable("idProduct") Long idProduct) {
        return ResponseEntity.ok(clientServices.findByIdProduct(idProduct));
    }


}
