package com.example.catalogosDashboard.Service.Nomina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Nomina.c_TipoContratoEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_TipoContratoRepository;

@Service
public class c_TipoContratoService {
    @Autowired
    c_TipoContratoRepository cTipoContratoRepository; 

    /* public List<c_TipoContratoEntity> getAllTipoContrato(){
        return cTipoContrato.findAll();
    } */

    public List<c_TipoContratoEntity> getAllTipoContratoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoContratoEntity> tipoContrato = cTipoContratoRepository.findDataByStatus(status, sort);
        return tipoContrato;
    }

    public Optional<c_TipoContratoEntity> getTipoContratoById(String id){
        return cTipoContratoRepository.findById(id);        
    }
}
