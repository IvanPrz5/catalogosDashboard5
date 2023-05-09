package com.example.catalogosDashboard.Repository.Usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Usuarios.UsuariosEntity;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer>{
    Optional<UsuariosEntity> findOneByEmail(String email);
}