package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ClaveProdServ;

public interface c_ClaveProdServRepository extends JpaRepository <c_ClaveProdServ, String> {
    // List<c_BancoEntity> findAll();
    List<c_ClaveProdServ> findDataByStatus(Boolean status, Sort sort);
    // Optional<c_ClaveProdServ> findById(String id);
}
