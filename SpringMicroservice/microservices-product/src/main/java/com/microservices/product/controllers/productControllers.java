package com.microservices.product.controllers;

import com.microservices.product.entity.productEntity;
import com.microservices.product.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class productControllers {

    @Autowired
    private IProductServices productServices;

    @PostMapping("/create")
    public ResponseEntity<productEntity> saveProduc(@RequestBody @Validated productEntity product) {
        return ResponseEntity.ok(productServices.guardarProductos(product));
    }

    @GetMapping("/search/{idProduct}")
    public ResponseEntity<productEntity> getProductId(@PathVariable("idProduct") Long idProduct) {
        return ResponseEntity.ok(productServices.obtenerProductoPorId(idProduct));
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAllProduct() {
        return ResponseEntity.ok(productServices.listarTodosProductos());
    }

    @PutMapping("/update/search/{idProduct}")
    public ResponseEntity<productEntity> updateProductId(@PathVariable("idProduct") Long idProduct, @RequestBody @Validated productEntity detalles) {
        return ResponseEntity.ok(productServices.actualizarProductoPorId(idProduct, detalles));
    }


    @DeleteMapping("/delete/search/{idProduct}")
    public ResponseEntity<?> deleteProductId(@PathVariable("idProduct") Long idProduct) {
        productServices.eliminarProductoPorId(idProduct);
        return ResponseEntity.ok("Producto eliminado con éxito.");
    }

}
