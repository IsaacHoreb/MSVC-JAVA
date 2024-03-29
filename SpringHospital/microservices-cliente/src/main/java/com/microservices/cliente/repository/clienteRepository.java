package com.microservices.cliente.repository;

import com.microservices.cliente.entity.clientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<clientEntity, Long> {


}
