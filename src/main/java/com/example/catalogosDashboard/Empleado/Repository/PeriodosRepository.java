package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.PeriodosEntity;

public interface PeriodosRepository extends JpaRepository<PeriodosEntity, Long>{
    List<PeriodosEntity> findByStatus(Boolean status, Sort sort);
}
