package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoRegimenEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoRegimenRepository;


@Service
public class c_TipoRegimenService {
    @Autowired
    c_TipoRegimenRepository cTipoRegimenRepository; 

    /* public List<c_TipoRegimenEntity> getAllRegimen(){
        return cTipoRegimenRepository.findAll();
    } */

    public List<c_TipoRegimenEntity> getAllTipoRegimenByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoRegimenEntity> tipoRegimen = cTipoRegimenRepository.findDataByStatus(status, sort);
        return tipoRegimen;
    }

    public Optional<c_TipoRegimenEntity> getTipoRegimenById(String id){
        return cTipoRegimenRepository.findById(id);        
    }
}
