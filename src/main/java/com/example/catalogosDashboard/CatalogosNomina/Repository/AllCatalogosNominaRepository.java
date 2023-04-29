package com.example.catalogosDashboard.CatalogosNomina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosNomina.Entity.AllCatalogosNominaEntity;

public interface AllCatalogosNominaRepository extends JpaRepository <AllCatalogosNominaEntity, Integer> {
    
}
