package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.EmpresaPercepcionEntity;

public interface EmpresaPercepcionRepository extends JpaRepository<EmpresaPercepcionEntity, Long>{
    List<EmpresaPercepcionEntity> findByStatus(Boolean status, Sort sort);
}
