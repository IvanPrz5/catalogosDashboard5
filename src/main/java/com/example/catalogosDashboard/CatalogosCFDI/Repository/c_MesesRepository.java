package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Meses;

public interface c_MesesRepository extends JpaRepository <c_Meses, String> {
    List<c_Meses> findDataByStatus(Boolean status, Sort sort);
    
}
