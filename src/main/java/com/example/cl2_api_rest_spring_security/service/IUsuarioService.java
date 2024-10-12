package com.example.cl2_api_rest_spring_security.service;


import com.example.cl2_api_rest_spring_security.model.Usuario;

public interface IUsuarioService {

    Usuario obtenerUsuarioXnombre(String nomUsuario);
}
