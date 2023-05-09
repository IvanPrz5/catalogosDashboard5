package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoOtroPagoEntity;

public interface c_TipoOtroPagoRepository extends JpaRepository<c_TipoOtroPagoEntity, String>{
    // List<c_TipoOtroPagoEntity> findAll();
    Optional<c_TipoOtroPagoEntity> findById(String id);
    List<c_TipoOtroPagoEntity> findDataByStatus(Boolean status, Sort sort);
}
