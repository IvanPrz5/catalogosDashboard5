package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_RiesgoPuestoEntity;

public interface c_RiesgoPuestoRepository extends JpaRepository<c_RiesgoPuestoEntity, String>{
    // List<c_RiesgoPuestoEntity> findAll();
    List<c_RiesgoPuestoEntity> findDataByStatus(Boolean status, Sort sort);
    Optional<c_RiesgoPuestoEntity> findById(Integer id);
}
