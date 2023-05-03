package com.example.catalogosDashboard.Empleado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.EstadoCivilEntity;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, Long>{
    
}
