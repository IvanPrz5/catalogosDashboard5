package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_PeriodicidadPagoEntity;

public interface c_PeriodicidadPagoRepository extends JpaRepository<c_PeriodicidadPagoEntity, String>{
    // List<c_PeriodicidadPagoEntity> findAll();
    List<c_PeriodicidadPagoEntity> findDataByStatus(Boolean status, Sort sort);
    Optional<c_PeriodicidadPagoEntity> findById(String id);
}
