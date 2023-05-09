package com.example.catalogosDashboard.Repository.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.ContactoEntity;

public interface ContactoRepository extends JpaRepository<ContactoEntity, Integer>{
    
}
