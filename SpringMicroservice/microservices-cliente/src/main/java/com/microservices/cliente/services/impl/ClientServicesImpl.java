package com.microservices.cliente.services.impl;

import com.microservices.cliente.entity.clientEntity;
import com.microservices.cliente.repository.clienteRepository;
import com.microservices.cliente.services.IClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImpl implements IClientServices {

    @Autowired
    private clienteRepository clienteRepository;

    @Override
    public clientEntity guardarCliente(clientEntity client) {
        return clienteRepository.save(client);
    }

    @Override
    public clientEntity obtenerClientPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    @Override
    public clientEntity actualizarClientPorId(Long id, clientEntity nuevo) {

        //Almacenar el id buscado
        clientEntity local = clienteRepository.findById(id)
                .orElseThrow();

        clientEntity clientNew = null; //Nuevo datos

        if (local != null) {

            //Agregamos los datos nuevos
            local.setName(nuevo.getName());
            local.setLastName(nuevo.getLastName());
            local.setAge(nuevo.getAge());
            local.setEmail(nuevo.getEmail());
            local.setAddress(nuevo.getAddress());

            //Guardamos los datos nuevos
            clientNew = clienteRepository.save(local);
        }

        return clientNew;
    }

    @Override
    public void eliminarClientPorId(Long id) {

        //Almacenar el id buscado
        clientEntity local = clienteRepository.findById(id)
                .orElseThrow();

        if (local != null) {
            clienteRepository.deleteById(id);
        }

    }

    @Override
    public List<clientEntity> listarTodoClientes() {
        return clienteRepository.findAll();
    }

    //Para comunicar
    @Override
    public List<clientEntity> findByIdProduct(Long idProduct) {
        return clienteRepository.findAllClient(idProduct);
    }
    
}
