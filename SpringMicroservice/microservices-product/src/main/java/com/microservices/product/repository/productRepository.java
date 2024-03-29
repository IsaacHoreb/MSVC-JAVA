package com.microservices.product.repository;

import com.microservices.product.entity.productEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<productEntity, Long> {

}
