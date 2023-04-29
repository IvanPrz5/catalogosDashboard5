package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.UsuariosNominaEntity;

public interface UsuariosNominaRepository extends JpaRepository<UsuariosNominaEntity, Long>{
    List<UsuariosNominaEntity> findByStatus(Boolean status, Sort sort);
}
