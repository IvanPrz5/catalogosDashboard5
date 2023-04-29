package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Exportacion;

public interface c_ExportacionRepository extends JpaRepository <c_Exportacion, String> {
    List<c_Exportacion> findDataByStatus(Boolean status, Sort sort);
}
