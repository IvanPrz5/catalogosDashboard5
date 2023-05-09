package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoNominaEntity;

public interface c_TipoNominaRepository extends JpaRepository<c_TipoNominaEntity, String>{
    // List<c_TipoNominaEntity> findAll();
    Optional<c_TipoNominaEntity> findById(String id);
    List<c_TipoNominaEntity> findDataByStatus(Boolean status, Sort sort);
}
