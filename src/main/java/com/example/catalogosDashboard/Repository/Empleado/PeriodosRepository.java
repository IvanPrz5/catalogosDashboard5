package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.PeriodosEntity;

public interface PeriodosRepository extends JpaRepository<PeriodosEntity, Long>{
    List<PeriodosEntity> findByStatus(Boolean status, Sort sort);
}
