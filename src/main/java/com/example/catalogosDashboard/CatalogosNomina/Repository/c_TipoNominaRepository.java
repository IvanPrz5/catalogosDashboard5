package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoNominaEntity;

public interface c_TipoNominaRepository extends JpaRepository<c_TipoNominaEntity, String>{
    // List<c_TipoNominaEntity> findAll();
    Optional<c_TipoNominaEntity> findById(String id);
    List<c_TipoNominaEntity> findDataByStatus(Boolean status, Sort sort);
}
