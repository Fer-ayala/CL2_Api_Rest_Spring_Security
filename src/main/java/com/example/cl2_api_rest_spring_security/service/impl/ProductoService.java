package com.example.cl2_api_rest_spring_security.service.impl;

import com.example.cl2_api_rest_spring_security.model.Producto;
import com.example.cl2_api_rest_spring_security.repository.ProductoRepository;
import com.example.cl2_api_rest_spring_security.service.IProductoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarProductoXId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardarProducto(Producto p) {
        return productoRepository.save(p);
    }

}
