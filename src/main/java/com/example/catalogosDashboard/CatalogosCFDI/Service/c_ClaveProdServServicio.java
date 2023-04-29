package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ClaveProdServ;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ClaveProdServRepository;

@Service
public class c_ClaveProdServServicio {

    @Autowired
    c_ClaveProdServRepository cClaveProdServRepository; 

    public List<c_ClaveProdServ> getAllClaveProdServByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_ClaveProdServ> claveProdServ = cClaveProdServRepository.findDataByStatus(status, sort);
        return claveProdServ;
    }

    /* public Optional<c_ClaveProdServ> getAduanaById(String id){
        return cClaveProdServRepository.findById(id);        
    } */
}
