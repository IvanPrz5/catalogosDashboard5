package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoNominaEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoNominaRepository;


@Service
public class c_TipoNominaService {
    @Autowired
    c_TipoNominaRepository cTipoNominaRepository; 

    /* public List<c_TipoNominaEntity> getAllTipoNomina() {
        return cTipoNominaRepository.findAll();
    }
 */
    public List<c_TipoNominaEntity>  getAllTipoNominaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoNominaEntity> tipoNomina = cTipoNominaRepository.findDataByStatus(status, sort);
        return tipoNomina;
    }

    public Optional<c_TipoNominaEntity> getTipoNominaById(String id){
        return cTipoNominaRepository.findById(id);        
    }
}
