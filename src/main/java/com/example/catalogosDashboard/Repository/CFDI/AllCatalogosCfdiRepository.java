package com.example.catalogosDashboard.Repository.CFDI;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.AllCatalogosCfdiEntity;

public interface AllCatalogosCfdiRepository extends JpaRepository <AllCatalogosCfdiEntity, Integer> {
    
}