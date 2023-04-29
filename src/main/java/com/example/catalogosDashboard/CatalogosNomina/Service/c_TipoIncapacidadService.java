package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoIncapacidadEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoIncapacidadRepository;

@Service
public class c_TipoIncapacidadService {
    @Autowired
    c_TipoIncapacidadRepository cTipoIncapacidadRepository; 

    /* public List<c_TipoIncapacidadEntity> getAllTipoIncapacidad(){
        return cTipoIncapacidadRepository.findAll();
    } */

    public List<c_TipoIncapacidadEntity>  getAllTipoIncapacidadByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoIncapacidadEntity> tipoIncapacidad = cTipoIncapacidadRepository.findDataByStatus(status, sort);
        return tipoIncapacidad;
    }

    public Optional<c_TipoIncapacidadEntity> getTipoIncapacidadById(String id){
        return cTipoIncapacidadRepository.findById(id);        
    }
}
