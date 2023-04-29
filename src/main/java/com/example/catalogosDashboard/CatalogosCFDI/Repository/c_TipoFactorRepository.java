package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TipoFactor;

public interface c_TipoFactorRepository extends JpaRepository <c_TipoFactor, String> {
    List<c_TipoFactor> findDataByStatus(Boolean status, Sort sort);
    
}
