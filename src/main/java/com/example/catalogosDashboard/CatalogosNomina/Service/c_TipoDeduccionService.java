package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoDeduccionEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoDeduccionRepository;


@Service
public class c_TipoDeduccionService {
    @Autowired
    c_TipoDeduccionRepository cTipoDeduccionRepository; 

    /* public List<c_TipoDeduccionEntity> getAllTipoDeducc(){
        return cTipoDeduccionRepository.findAll();
    } */

    public List<c_TipoDeduccionEntity> getAllTipoDeduccionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoDeduccionEntity> tipoDeduccion= cTipoDeduccionRepository.findDataByStatus(status, sort);
        return tipoDeduccion;
    }

    public Optional<c_TipoDeduccionEntity> getTipoDeduccionById(String id){
        return cTipoDeduccionRepository.findById(id);        
    }
}
