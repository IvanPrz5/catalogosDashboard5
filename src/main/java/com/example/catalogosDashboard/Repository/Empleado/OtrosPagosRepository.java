package com.example.catalogosDashboard.Repository.Empleado;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.OtrosPagosEntity;

import java.util.List;

public interface OtrosPagosRepository extends JpaRepository<OtrosPagosEntity, Long> {
  List<OtrosPagosEntity> findByStatus(Boolean status, Sort sort);
}
