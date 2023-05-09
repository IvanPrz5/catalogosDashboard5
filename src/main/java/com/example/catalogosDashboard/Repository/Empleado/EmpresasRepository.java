package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;

public interface EmpresasRepository extends JpaRepository<EmpresasEntity, Long> {
    List<EmpresasEntity> findDataByStatus(Boolean status, Sort sort);
}
