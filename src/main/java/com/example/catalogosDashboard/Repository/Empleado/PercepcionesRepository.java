package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.PercepcionesEntity;

public interface PercepcionesRepository extends JpaRepository<PercepcionesEntity, Long>{
    List<PercepcionesEntity> findByStatus(Boolean status, Sort sort);
}
