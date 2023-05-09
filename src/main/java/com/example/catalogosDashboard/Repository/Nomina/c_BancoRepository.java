package com.example.catalogosDashboard.Repository.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.c_BancoEntity;

public interface c_BancoRepository extends JpaRepository<c_BancoEntity, String>{
    // List<c_BancoEntity> findAll();
    List<c_BancoEntity> findDataByStatus(Boolean status, Sort sort);
    Optional<c_BancoEntity> findById(String id);
}
