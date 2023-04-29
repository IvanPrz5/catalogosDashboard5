package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.PercepcionesEntity;

public interface PercepcionesRepository extends JpaRepository<PercepcionesEntity, Long>{
    List<PercepcionesEntity> findByStatus(Boolean status, Sort sort);
}
