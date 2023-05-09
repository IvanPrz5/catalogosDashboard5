package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.SindicatoEntity;

public interface SindicatoRepository extends JpaRepository<SindicatoEntity, Long>{
    List <SindicatoEntity> findDataByStatus(Boolean status, Sort sort);
}
