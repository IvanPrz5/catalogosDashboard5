package com.example.catalogosDashboard.Authentication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Authentication.Entity.UsuariosEntity;

public interface UsuarioRepository extends JpaRepository <UsuariosEntity, Integer> {
    Optional<UsuariosEntity> findOneByEmail(String email);  
}
