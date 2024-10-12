package com.example.cl2_api_rest_spring_security.service.impl;

import com.example.cl2_api_rest_spring_security.model.Producto;
import com.example.cl2_api_rest_spring_security.repository.ProductoRepository;
import com.example.cl2_api_rest_spring_security.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarProductoXId(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public String registrarProducto(Producto p) {
            productoRepository.save(p);
            return "Producto registrado con exito";
    }

    @Override
    public String actualizarProducto(Producto p) {

        Optional<Producto> producto = productoRepository.findById(p.getIdproducto());
        if(producto.isPresent()){
            producto.get().setNombre(p.getNombre());
            producto.get().setDescripcion(p.getDescripcion());
            producto.get().setPrecio(p.getPrecio());
            productoRepository.save(producto.get());
            return "Producto actualizado con exito";
        }
        return "No se pudo actualizar el producto";
    }
}
