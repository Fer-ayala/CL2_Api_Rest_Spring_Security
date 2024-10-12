package com.example.cl2_api_rest_spring_security.service;

import com.example.cl2_api_rest_spring_security.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> obtenerProductos();
    Producto buscarProductoXId();
    String registrarProducto();
    String actualizarProducto();
}
