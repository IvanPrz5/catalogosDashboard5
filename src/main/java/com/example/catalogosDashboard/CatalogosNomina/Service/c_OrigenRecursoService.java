package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_OrigenRecursoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_OrigenRecursoRepository;

@Service
public class c_OrigenRecursoService {
    @Autowired
    c_OrigenRecursoRepository cOrigenRecursoRepository; 

    /* public List<c_OrigenRecursoEntity> getAllOrigenRecurso(){
        return cOrigenRecursoRepository.findAll();
    } */

    /* public Optional<c_OrigenRecursoEntity> getByCodOrigenRecurso(String cod){
        return cOrigenRecursoRepository.findByCod(cod);
    } */

    public List<c_OrigenRecursoEntity> getAllOrigenRecursoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_OrigenRecursoEntity> origenRecurso = cOrigenRecursoRepository.findDataByStatus(status, sort);
        return origenRecurso;
    }

    public Optional<c_OrigenRecursoEntity> getOrigenRecursoById(Integer id){
        return cOrigenRecursoRepository.findById(id);        
    }
}
