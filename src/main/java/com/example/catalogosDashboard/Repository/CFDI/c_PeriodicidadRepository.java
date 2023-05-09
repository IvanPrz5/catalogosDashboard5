package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_Periodicidad;

public interface c_PeriodicidadRepository extends JpaRepository <c_Periodicidad, String>{
    List<c_Periodicidad> findDataByStatus(Boolean status, Sort sort);
    
}
