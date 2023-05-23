package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpleadoEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{
    List<EmpleadoEntity> findDataByStatus(Boolean status, Sort sort);
    List<EmpleadoEntity> findByIdSubEmpresaAndStatus(SubEmpresasEntity id, Boolean status, Sort sort);
}