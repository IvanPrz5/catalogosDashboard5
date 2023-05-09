package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.DepartamentoEntity;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>{
    List<DepartamentoEntity> findDataByStatus(Boolean status, Sort sort);
}
