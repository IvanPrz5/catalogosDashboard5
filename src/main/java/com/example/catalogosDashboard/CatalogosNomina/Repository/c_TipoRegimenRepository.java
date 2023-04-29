package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoRegimenEntity;

public interface c_TipoRegimenRepository extends JpaRepository<c_TipoRegimenEntity, String>{
    // List<c_TipoRegimenEntity> findAll();
    Optional<c_TipoRegimenEntity> findById(String id);
    List<c_TipoRegimenEntity> findDataByStatus(Boolean status, Sort sort);
}
