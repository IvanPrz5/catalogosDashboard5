package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.EmpresaDeduccionEntity;

public interface EmpresaDeduccionRepository extends JpaRepository<EmpresaDeduccionEntity, Long>{
    List<EmpresaDeduccionEntity> findByStatus(Boolean status, Sort sort);
}
