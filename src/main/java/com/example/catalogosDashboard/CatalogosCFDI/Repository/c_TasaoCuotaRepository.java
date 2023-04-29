package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TasaoCuota;

public interface c_TasaoCuotaRepository extends JpaRepository <c_TasaoCuota, Integer>{
    List<c_TasaoCuota> findDataByStatus(Boolean status, Sort sort);
}
