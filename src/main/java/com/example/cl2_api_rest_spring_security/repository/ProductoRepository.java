package com.example.cl2_api_rest_spring_security.repository;

import com.example.cl2_api_rest_spring_security.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
