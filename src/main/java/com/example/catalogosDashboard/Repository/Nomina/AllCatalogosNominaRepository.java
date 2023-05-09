package com.example.catalogosDashboard.Repository.Nomina;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Nomina.AllCatalogosNominaEntity;

public interface AllCatalogosNominaRepository extends JpaRepository <AllCatalogosNominaEntity, Integer> {
    
}
