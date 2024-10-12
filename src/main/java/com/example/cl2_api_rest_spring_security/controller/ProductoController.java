package com.example.cl2_api_rest_spring_security.controller;


import com.example.cl2_api_rest_spring_security.exception.ResourceNotFoundException;
import com.example.cl2_api_rest_spring_security.model.Producto;
import com.example.cl2_api_rest_spring_security.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    private IProductoService iProductoService;

    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> obtenerProductos(){

        List<Producto> lista = iProductoService.listarProductos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(iProductoService.guardarProducto(producto), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Integer id,
            @RequestBody Producto producto
    ){
        Producto newProducto = iProductoService.buscarProductoXId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con Id "
                        + id +" no existe"));

        newProducto.setNombre(producto.getNombre());
        newProducto.setDescripcion(producto.getDescripcion());
        newProducto.setPrecio(producto.getPrecio());
        return new ResponseEntity<>(
                iProductoService.guardarProducto(newProducto),
                HttpStatus.OK
        );
    }
}
