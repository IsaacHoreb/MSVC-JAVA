package com.microservices.cliente.repository;

import com.microservices.cliente.entity.clientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clienteRepository extends JpaRepository<clientEntity, Long> {

    //Para traer datos
    @Query("SELECT c FROM clientEntity WHERE c.productId = :idProduct")
    List<clientEntity> findAllClient(Long idProduct);

}
