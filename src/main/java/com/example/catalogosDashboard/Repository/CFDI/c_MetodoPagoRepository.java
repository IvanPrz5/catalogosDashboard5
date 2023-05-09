package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_MetodoPago;

public interface c_MetodoPagoRepository extends JpaRepository <c_MetodoPago, String> {
    List<c_MetodoPago> findDataByStatus(Boolean status, Sort sort);
    
}
