package com.example.cl2_api_rest_spring_security.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponseDto {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}
