package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{
    List<EmpleadoEntity> findDataByStatus(Boolean status, Sort sort);
}