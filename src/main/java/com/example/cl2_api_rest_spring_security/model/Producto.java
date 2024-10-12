package com.example.cl2_api_rest_spring_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "productos")
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;
}
