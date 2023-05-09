package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;

public interface c_CodigoPostalRepository extends JpaRepository <c_CodigoPostal, String> {
    List<c_CodigoPostal> findDataByStatus(Boolean status, Sort sort);
    
}
