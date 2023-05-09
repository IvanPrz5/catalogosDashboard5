package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.PuestoEntity;

public interface PuestoRepository extends JpaRepository<PuestoEntity, Long>{
    List<PuestoEntity> findDataByStatus(Boolean status, Sort sort);
}
