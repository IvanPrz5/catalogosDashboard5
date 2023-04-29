package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ClaveUnidad;

public interface c_ClaveUnidadRepository extends JpaRepository <c_ClaveUnidad, String> {
    List<c_ClaveUnidad> findDataByStatus(Boolean status, Sort sort);
    
}
