package com.example.catalogosDashboard.Service.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoHorasEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_TipoHorasRepository;

@Service
public class c_TipoHorasService {
    @Autowired
    c_TipoHorasRepository cTipoHorasRepository; 

    /* public List<c_TipoHorasEntity> getAllTipoHoras(){
        return cTipoHorasRepository.findAll();
    } */

    public List<c_TipoHorasEntity> getAllTipoHorasByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoHorasEntity> tipoHoras = cTipoHorasRepository.findDataByStatus(status, sort);
        return tipoHoras;
    }

    public Optional<c_TipoHorasEntity> getTipoHorasById(String id){
        return cTipoHorasRepository.findById(id);        
    }
}
