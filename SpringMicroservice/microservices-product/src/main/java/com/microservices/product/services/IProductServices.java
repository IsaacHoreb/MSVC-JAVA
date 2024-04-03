package com.microservices.product.services;

import com.microservices.product.entity.productEntity;
import com.microservices.product.http.response.ClientByProductResponse;

import java.util.List;

public interface IProductServices {

    productEntity guardarProductos(productEntity product);

    productEntity obtenerProductoPorId(Long id);

    productEntity actualizarProductoPorId(Long id, productEntity detalles);

    void eliminarProductoPorId(Long id);

    List<productEntity> listarTodosProductos();

    //Agregar despues del ClientDTOS pero hay que hacer el HTTP
    ClientByProductResponse findClientByIdProduct(Long idProduct);

}
