package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Moneda;

public interface c_MonedaRepository extends JpaRepository <c_Moneda, String> {
    List<c_Moneda> findDataByStatus(Boolean status, Sort sort);
    
}
