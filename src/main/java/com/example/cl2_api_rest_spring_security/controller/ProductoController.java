package com.example.cl2_api_rest_spring_security.controller;


import com.example.cl2_api_rest_spring_security.model.Producto;
import com.example.cl2_api_rest_spring_security.service.impl.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    private ProductoService productoService;

    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos(){

        List<Producto> lista = productoService.obtenerProductos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
