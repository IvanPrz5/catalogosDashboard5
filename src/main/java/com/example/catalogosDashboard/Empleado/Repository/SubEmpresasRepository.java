package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.SubEmpresasEntity;

public interface SubEmpresasRepository extends JpaRepository<SubEmpresasEntity, Long>{
    List<SubEmpresasEntity> findDataByStatus(Boolean status, Sort sort);
    
}
