package com.example.catalogosDashboard.Repository.Nomina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.catalogosDashboard.Entity.Nomina.AllCatalogosNominaEntity;
import java.util.List;


public interface AllCatalogosNominaRepository extends JpaRepository <AllCatalogosNominaEntity, Integer> {
    
}
