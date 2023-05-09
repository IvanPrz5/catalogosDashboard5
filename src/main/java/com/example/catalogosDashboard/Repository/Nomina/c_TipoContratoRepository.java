package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoContratoEntity;

public interface c_TipoContratoRepository extends JpaRepository<c_TipoContratoEntity, String>{
    // List<c_TipoContratoEntity> findAll();
    Optional<c_TipoContratoEntity> findById(String id);
    List<c_TipoContratoEntity> findDataByStatus(Boolean status, Sort sort);
}
