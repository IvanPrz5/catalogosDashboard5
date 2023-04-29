package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Aduana;

public interface c_AduanaRepository extends JpaRepository<c_Aduana, String> {
    // List<c_BancoEntity> findAll();
    List<c_Aduana> findDataByStatus(Boolean status, Sort sort);
    // Optional<c_Aduana> findById(String id);
}
