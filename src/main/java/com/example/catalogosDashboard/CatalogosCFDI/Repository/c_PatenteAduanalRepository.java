package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_PatenteAduanal;

public interface c_PatenteAduanalRepository extends JpaRepository <c_PatenteAduanal, String>{
    List<c_PatenteAduanal> findDataByStatus(Boolean status, Sort sort);
}
