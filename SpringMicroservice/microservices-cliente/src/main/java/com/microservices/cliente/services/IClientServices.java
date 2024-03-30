package com.microservices.cliente.services;

import com.microservices.cliente.entity.clientEntity;

import java.util.List;

public interface IClientServices {

    clientEntity guardarCliente(clientEntity client);

    clientEntity obtenerClientPorId(Long id);

    clientEntity actualizarClientPorId(Long id, clientEntity nuevo);

    void eliminarClientPorId(Long id);

    List<clientEntity> listarTodoClientes();

    //Servicio para comunicar con el otro msvc
    List<clientEntity> findByIdProduct(Long idProduct);

}
