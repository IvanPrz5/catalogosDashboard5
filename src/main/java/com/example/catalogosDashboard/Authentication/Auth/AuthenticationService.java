package com.example.catalogosDashboard.Authentication.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Authentication.Config.JwtService;
import com.example.catalogosDashboard.Authentication.Entity.Role;
import com.example.catalogosDashboard.Authentication.Entity.UsuariosEntity;
import com.example.catalogosDashboard.Authentication.Repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var usuarios = UsuariosEntity.builder()
            .nombre(request.getNombre())
            .apellidos(request.getApellidos())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();

        usuarioRepository.save(usuarios);
        var jwtToken = jwtService.generateToken(usuarios);

        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        var usuarios = usuarioRepository.findOneByEmail(request.getEmail())
            .orElseThrow();
    
        var jwt = jwtService.generateToken(usuarios);

        return AuthenticationResponse.builder()
            .token(jwt)
            .build();
    }

}
