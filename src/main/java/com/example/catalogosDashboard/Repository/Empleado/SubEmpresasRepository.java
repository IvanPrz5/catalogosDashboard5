package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;

public interface SubEmpresasRepository extends JpaRepository<SubEmpresasEntity, Long>{
    List<SubEmpresasEntity> findDataByIdEmpresaAndStatus(EmpresasEntity id, Boolean status, Sort sort);

    
}
