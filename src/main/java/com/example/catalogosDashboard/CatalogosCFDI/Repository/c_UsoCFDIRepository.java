package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_UsoCFDI;

public interface c_UsoCFDIRepository extends JpaRepository <c_UsoCFDI, String>{
    List<c_UsoCFDI> findDataByStatus(Boolean status, Sort sort); 
}
