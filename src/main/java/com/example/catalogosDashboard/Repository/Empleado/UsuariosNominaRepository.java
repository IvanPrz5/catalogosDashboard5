package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.UsuariosNominaEntity;

public interface UsuariosNominaRepository extends JpaRepository<UsuariosNominaEntity, Long>{
    List<UsuariosNominaEntity> findByStatus(Boolean status, Sort sort);
}
