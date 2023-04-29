package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoPercepcionEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoPercepcionRepository;


@Service
public class c_TipoPercepcionService {
    @Autowired
    c_TipoPercepcionRepository cTipoPercepcionRepository; 

    public List<c_TipoPercepcionEntity> getAllTipoPercepcion(){
        return cTipoPercepcionRepository.findAll();
    }

    public List<c_TipoPercepcionEntity>  getAllTipoPercepcionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoPercepcionEntity> tipoPercepcion= cTipoPercepcionRepository.findDataByStatus(status, sort);
        return tipoPercepcion;
    }

    public Optional<c_TipoPercepcionEntity> getTipoPercepcionById(String id){
        return cTipoPercepcionRepository.findById(id);        
    }
}
