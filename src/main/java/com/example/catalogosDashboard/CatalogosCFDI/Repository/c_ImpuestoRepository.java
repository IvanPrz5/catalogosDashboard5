package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Impuesto;

public interface c_ImpuestoRepository extends JpaRepository<c_Impuesto, String> {
    List<c_Impuesto> findDataByStatus(Boolean status, Sort sort);
}
