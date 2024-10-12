package com.example.cl2_api_rest_spring_security.controller;

import com.example.cl2_api_rest_spring_security.dto.UsuarioResponseDto;
import com.example.cl2_api_rest_spring_security.model.Usuario;
import com.example.cl2_api_rest_spring_security.service.IUsuarioService;
import com.example.cl2_api_rest_spring_security.service.impl.DetalleUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final DetalleUsuarioService detalleUsuarioService;
    private final AuthenticationManager authenticationManager;
    private final IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDto> autenticarUsuario(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password
    ){
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(usuario,
                            password));
            if(authentication.isAuthenticated()){
                Usuario objUsuario = usuarioService.obtenerUsuarioXnombre(usuario);
                String token = generarToken(objUsuario);
                return new ResponseEntity<>(
                        UsuarioResponseDto.builder().idusuario(objUsuario.getIdusuario())
                                .nomusuario(objUsuario.getNomusuario())
                                .token(token).build(),
                        HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generarToken(Usuario usuario){
        String clave = "@Cibertec2024";
        List<GrantedAuthority> authorityList =
                detalleUsuarioService.obtenerRolesUsuario(usuario.getRoles());
        return Jwts.builder()
                .setId(usuario.getIdusuario().toString())
                .setSubject(usuario.getNomusuario())
                .claim("email", usuario.getEmail()) // Agregando el email al payload
                .claim("authorities",
                        authorityList.stream().map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 180000))//Duración del token 3min = 180000ms
                .signWith(SignatureAlgorithm.HS512, clave.getBytes())
                .compact();
    }
}
