package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Pais;

public interface c_PaisRepository extends JpaRepository<c_Pais, String> {
    List<c_Pais> findDataByStatus(Boolean status, Sort sort);

}
