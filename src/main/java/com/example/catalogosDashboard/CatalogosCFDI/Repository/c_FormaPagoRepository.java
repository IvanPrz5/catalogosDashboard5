package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_FormaPago;

public interface c_FormaPagoRepository extends JpaRepository <c_FormaPago, String> {
    List<c_FormaPago> findDataByStatus(Boolean status, Sort sort);
    
}
