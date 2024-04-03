package com.microservices.product.services.impl;

import com.microservices.product.client.ClientsClient;
import com.microservices.product.dto.ClientDTOS;
import com.microservices.product.entity.productEntity;
import com.microservices.product.http.response.ClientByProductResponse;
import com.microservices.product.repository.productRepository;
import com.microservices.product.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements IProductServices {

    @Autowired
    private productRepository repository;

    //Para obtener los datos del client
    @Autowired
    private ClientsClient client;

    @Override
    public productEntity guardarProductos(productEntity product) {
        return repository.save(product);
    }

    @Override
    public productEntity obtenerProductoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public productEntity actualizarProductoPorId(Long id, productEntity detalles) {

        //Almacenamos el id del productos
        productEntity local = repository.findById(id)
                .orElse(null);

        productEntity nuevo = null; //Nuevos datos

        if (local != null) {

            //Agregamos los detalles a actualizar
            local.setTipoProduct(detalles.getTipoProduct());
            local.setModelo(detalles.getModelo());
            local.setProcesador(detalles.getProcesador());
            local.setRam(detalles.getRam());
            local.setAlmacenamiento(detalles.getAlmacenamiento());
            local.setBateria(detalles.getBateria());
            local.setPantalla(detalles.getPantalla());
            local.setConectividad(detalles.getConectividad());
            local.setSistemaOperativo(detalles.getSistemaOperativo());
            local.setTipoSeguridad(detalles.getTipoSeguridad());
            local.setPrecio(detalles.getPrecio());

            //Guardar los datos nuevos
            nuevo = repository.save(local);
        }

        return nuevo;
    }

    @Override
    public void eliminarProductoPorId(Long id) {

        //Almacenamos el id del productos
        productEntity local = repository.findById(id)
                .orElse(null);

        if (local != null) {
            repository.deleteById(id);
        }

    }

    @Override
    public List<productEntity> listarTodosProductos() {
        return repository.findAll();
    }

    //Aqui la logica para mostrar los dos msvc
    @Override
    public ClientByProductResponse findClientByIdProduct(Long idProduct) {

        //Consultar el Producto
        productEntity product = repository.findById(idProduct)
                .orElse(new productEntity());

        //Consultar los Clientes
        List<ClientDTOS> clientDTOSList = client.findAllClientByProduct(idProduct);

        //Devolver los datos deseados
        return ClientByProductResponse.builder()
                .tipoProduct(product.getTipoProduct())
                .modelo(product.getModelo())
                .procesador(product.getProcesador())
                .ram(product.getRam())
                .almacenamiento(product.getAlmacenamiento())
                .bateria(product.getBateria())
                .pantalla(product.getPantalla())
                .conectividad(product.getConectividad())
                .sistemaOperativo(product.getSistemaOperativo())
                .tipoSeguridad(product.getTipoSeguridad())
                .precio(product.getPrecio())
                .clientDTOSList(clientDTOSList)
                .build();
    }

    //Despues agregarlo o usarlo en el controlador


}
