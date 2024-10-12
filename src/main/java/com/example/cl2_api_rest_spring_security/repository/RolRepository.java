package com.example.cl2_api_rest_spring_security.repository;

import com.example.cl2_api_rest_spring_security.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
