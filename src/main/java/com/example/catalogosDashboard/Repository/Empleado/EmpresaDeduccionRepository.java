package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpresaDeduccionEntity;

public interface EmpresaDeduccionRepository extends JpaRepository<EmpresaDeduccionEntity, Long>{
    List<EmpresaDeduccionEntity> findByStatus(Boolean status, Sort sort);
}
