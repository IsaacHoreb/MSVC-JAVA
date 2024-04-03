package com.microservice.jugadores.services.impl;

import com.microservice.jugadores.entity.jugadoresEntitys;
import com.microservice.jugadores.repository.jugadoresRepository;
import com.microservice.jugadores.services.IJugadoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadoresServicesImpl implements IJugadoresServices {

    @Autowired
    private jugadoresRepository repository;

    @Override
    public jugadoresEntitys guardarJugador(jugadoresEntitys jugadores) {
        return repository.save(jugadores);
    }

    @Override
    public jugadoresEntitys obtenerJugadorPorId(Long id) {

        jugadoresEntitys local = repository.findById(id).orElse(null);

        if (local != null) {
            return local;
        }

        return null;
    }

    @Override
    public jugadoresEntitys actualizarJugadorPorId(Long id, jugadoresEntitys detalles) {

        //Almacenar por id
        jugadoresEntitys local = repository.findById(id).orElse(null);

        jugadoresEntitys nuevo = null; //Guardar

        if (local != null) {

            local.setName(detalles.getName());
            local.setLastName(detalles.getLastName());
            local.setAge(detalles.getAge());
            local.setPhone(detalles.getPhone());

            nuevo = repository.save(local);

            return nuevo;
        }

        return null;
    }

    @Override
    public void eliminarJugadorPorId(Long id) {

        //Almacenar por id
        jugadoresEntitys local = repository.findById(id).orElse(null);

        if (local != null) {
            repository.deleteById(id);
        }

    }

    @Override
    public List<jugadoresEntitys> listarTodosJugadores() {
        return repository.findAll();
    }

    @Override
    public List<jugadoresEntitys> findByIdGame(Long idGame) {
        return repository.findAllJugador(idGame);
    }

}
