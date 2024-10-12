package com.example.cl2_api_rest_spring_security.service;

import com.example.cl2_api_rest_spring_security.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> obtenerProductos();
    Optional<Producto> buscarProductoXId(int id);
    String registrarProducto(Producto p);
    String actualizarProducto(Producto p);
}
