package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_TipoFactor;
import com.example.catalogosDashboard.Repository.CFDI.c_TipoFactorRepository;

@Service
public class c_TipoFactorService {
    @Autowired
    c_TipoFactorRepository cTipoFactorRepository; 

    public List<c_TipoFactor> getAllTipoFactorByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoFactor> TipoFactor = cTipoFactorRepository.findDataByStatus(status, sort);
        return TipoFactor;
    }  
}
