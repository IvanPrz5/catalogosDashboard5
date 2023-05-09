package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpresaOtrosPagosEntity;

public interface EmpresaOtrosPagosRepository extends JpaRepository<EmpresaOtrosPagosEntity, Long>{
    List<EmpresaOtrosPagosEntity> findByStatus(Boolean status, Sort sort);
}
