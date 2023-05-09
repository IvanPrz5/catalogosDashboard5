package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoPercepcionEntity;

public interface c_TipoPercepcionRepository extends JpaRepository<c_TipoPercepcionEntity, String>{
    // List<c_TipoPercepcionEntity> findAll();
    Optional<c_TipoPercepcionEntity> findById(String id);
    List<c_TipoPercepcionEntity> findDataByStatus(Boolean status, Sort sort);
}
