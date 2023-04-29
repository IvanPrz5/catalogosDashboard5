package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoJornadaEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoJornadaRepository;

@Service
public class c_TipoJornadaService {
    @Autowired
    c_TipoJornadaRepository cTipoJornadaRepository; 

    /* public List<c_TipoJornadaEntity> getAllTipoJornada(){
        return cTipoJornadaRepository.findAll();
    } */

    public List<c_TipoJornadaEntity>  getAllTipoJornadaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoJornadaEntity> tipoJornada = cTipoJornadaRepository.findDataByStatus(status, sort);
        return tipoJornada;
    }

    public Optional<c_TipoJornadaEntity> getTipoJornadaById(String id){
        return cTipoJornadaRepository.findById(id);        
    }
}
