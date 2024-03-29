package com.microservices.product.services;

import com.microservices.product.entity.productEntity;

import java.util.List;

public interface IProductServices {

    productEntity guardarProductos(productEntity product);

    productEntity obtenerProductoPorId(Long id);

    productEntity actualizarProductoPorId(Long id, productEntity detalles);

    void eliminarProductoPorId(Long id);

    List<productEntity> listarTodosProductos();

}
