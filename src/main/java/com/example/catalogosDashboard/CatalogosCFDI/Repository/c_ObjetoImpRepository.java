package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ObjetoImp;

public interface c_ObjetoImpRepository extends JpaRepository <c_ObjetoImp, String> {
    List<c_ObjetoImp> findDataByStatus(Boolean status, Sort sort);
    
}
