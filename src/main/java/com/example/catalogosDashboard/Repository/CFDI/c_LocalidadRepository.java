package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Entity.CFDI.c_Localidad;

public interface c_LocalidadRepository extends JpaRepository <c_Localidad, String>{
    List<c_Localidad> findDataByStatus(Boolean status, Sort sort);
    List<c_Localidad> findByEstadoAndStatus(c_Estado estado, Boolean status);
}
