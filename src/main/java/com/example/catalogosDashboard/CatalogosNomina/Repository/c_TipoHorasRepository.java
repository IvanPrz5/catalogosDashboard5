package com.example.catalogosDashboard.CatalogosNomina.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoHorasEntity;

public interface c_TipoHorasRepository extends JpaRepository<c_TipoHorasEntity, String>{
    // List<c_TipoHorasEntity> findAll();
    Optional<c_TipoHorasEntity> findById(String id);
    List<c_TipoHorasEntity> findDataByStatus(Boolean status, Sort sort);
}
