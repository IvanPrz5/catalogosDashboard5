package com.example.catalogosDashboard.CatalogosCFDI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.AllCatalogosCfdiEntity;

public interface AllCatalogosCfdiRepository extends JpaRepository <AllCatalogosCfdiEntity, Integer> {
    
}