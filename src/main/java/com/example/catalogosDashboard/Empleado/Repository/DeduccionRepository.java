package com.example.catalogosDashboard.Empleado.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Empleado.Entity.DeduccionEntity;

public interface DeduccionRepository extends JpaRepository<DeduccionEntity, Long> {
    List<DeduccionEntity> findDataByStatus(Boolean status, Sort sort);
}
