package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoDeduccionEntity;

public interface c_TipoDeduccionRepository extends JpaRepository<c_TipoDeduccionEntity, String>{
    // List<c_TipoDeduccionEntity> findAll();
    List<c_TipoDeduccionEntity>findDataByStatus(Boolean status, Sort sort);
    Optional<c_TipoDeduccionEntity> findById(String id);
}
