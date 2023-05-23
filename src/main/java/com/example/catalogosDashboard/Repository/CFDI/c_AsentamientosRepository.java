package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_Asentamientos;
import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;

public interface c_AsentamientosRepository extends JpaRepository<c_Asentamientos, String>{
    List<c_Asentamientos> findByIdCodigoPostalAndStatus(c_CodigoPostal idCodPostal, Boolean status, Sort sort);
    // public List<c_Asentamientos> findDataByStatus(Boolean status, Pageable pageable);
    // public Page<c_Asentamientos> findDataByStatus(Boolean status, Pageable pageable);
}
