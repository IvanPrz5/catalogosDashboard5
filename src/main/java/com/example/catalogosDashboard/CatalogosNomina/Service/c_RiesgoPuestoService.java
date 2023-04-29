package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_RiesgoPuestoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_RiesgoPuestoRepository;

@Service
public class c_RiesgoPuestoService {
    @Autowired
    c_RiesgoPuestoRepository cRiesgoPuestoRepository; 

    /* public List<c_RiesgoPuestoEntity> getAllRiesgoPuesto(){
        return cRiesgoPuestoRepository.findAll();
    } */

    public List<c_RiesgoPuestoEntity> getAllRiesgoPuestoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_RiesgoPuestoEntity> riesgoPuesto = cRiesgoPuestoRepository.findDataByStatus(status, sort);
        return riesgoPuesto;
    }

    public Optional<c_RiesgoPuestoEntity> getRiesgoPuestoById(Integer id){
        return cRiesgoPuestoRepository.findById(id);        
    }

    /* public Optional<c_OrigenRecursoEntity> getOrigenRecursoByC_OriRec(String c_Origen_Recurso){
        return cOrigenRecursoRepository.findByC_OrigenRecurso(c_Origen_Recurso);        
    } */
}
