package com.example.cl2_api_rest_spring_security.service.impl;

import com.example.cl2_api_rest_spring_security.repository.UsuarioRepository;
import com.example.cl2_api_rest_spring_security.service.IUsuarioService;
import com.example.cl2_api_rest_spring_security.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioXnombre(String nomUsuario) {
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
}
