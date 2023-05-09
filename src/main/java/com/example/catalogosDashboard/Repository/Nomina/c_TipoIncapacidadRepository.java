package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoIncapacidadEntity;

public interface c_TipoIncapacidadRepository extends JpaRepository<c_TipoIncapacidadEntity, String>{
    // List<c_TipoIncapacidadEntity> findAll();
    Optional<c_TipoIncapacidadEntity> findById(String id);
    List<c_TipoIncapacidadEntity> findDataByStatus(Boolean status, Sort sort);
}
