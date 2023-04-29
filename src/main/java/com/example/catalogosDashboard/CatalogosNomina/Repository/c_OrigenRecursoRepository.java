package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_OrigenRecursoEntity;

public interface c_OrigenRecursoRepository extends JpaRepository<c_OrigenRecursoEntity, Integer> {
    // List<c_OrigenRecursoEntity> findAll();
    List<c_OrigenRecursoEntity> findDataByStatus(Boolean status, Sort sort);
    Optional<c_OrigenRecursoEntity> findById(Integer id);
    // Optional<c_OrigenRecursoEntity> findByC_OrigenRecurso(String c_Origen_Recurso);
}
