package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.EmpresasEntity;

public interface EmpresasRepository extends JpaRepository<EmpresasEntity, Long> {
    List<EmpresasEntity> findDataByStatus(Boolean status, Sort sort);
}
