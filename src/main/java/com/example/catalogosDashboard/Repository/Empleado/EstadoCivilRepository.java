package com.example.catalogosDashboard.Repository.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EstadoCivilEntity;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, Long>{
    
}
