package com.example.catalogosDashboard.Empleado.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.OtrosPagosEntity;

import java.util.List;

public interface OtrosPagosRepository extends JpaRepository<OtrosPagosEntity, Long> {
  List<OtrosPagosEntity> findByStatus(Boolean status, Sort sort);
}
