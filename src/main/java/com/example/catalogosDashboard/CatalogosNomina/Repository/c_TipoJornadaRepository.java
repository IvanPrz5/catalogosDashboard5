package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoJornadaEntity;

public interface c_TipoJornadaRepository extends JpaRepository<c_TipoJornadaEntity, String>{
    // List<c_TipoJornadaEntity> findAll();
    Optional<c_TipoJornadaEntity> findById(String id);
    List<c_TipoJornadaEntity> findDataByStatus(Boolean status, Sort sort);
}
