package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;
import com.example.catalogosDashboard.Entity.CFDI.c_Estado;

public interface c_CodigoPostalRepository extends JpaRepository <c_CodigoPostal, String> {
    List<c_CodigoPostal> findDataByStatus(Boolean status, Sort sort);
    Optional<c_CodigoPostal> findByIdAndStatus(String id, Boolean status, Sort sort);
    List<c_CodigoPostal> findByIdEstadoAndStatus(c_Estado id, Boolean status, Sort sort);
}
