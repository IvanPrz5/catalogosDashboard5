package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_Impuesto;

public interface c_ImpuestoRepository extends JpaRepository<c_Impuesto, String> {
    List<c_Impuesto> findDataByStatus(Boolean status, Sort sort);
}
