package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoOtroPagoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoOtroPagoRepository;


@Service
public class c_TipoOtroPagoService {
    @Autowired
    c_TipoOtroPagoRepository cTipoOtroPagoRepository; 

    /* public List<c_TipoOtroPagoEntity> getAllTipoOPago(){
        return cTipoOtroPagoRepository.findAll();
    } */

    public List<c_TipoOtroPagoEntity> getAllTipoOtroPagoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoOtroPagoEntity> tipoOtroPago = cTipoOtroPagoRepository.findDataByStatus(status, sort);
        return tipoOtroPago;
    }

    public Optional<c_TipoOtroPagoEntity> getTipoOtroPagoById(String id){
        return cTipoOtroPagoRepository.findById(id);        
    }
}
