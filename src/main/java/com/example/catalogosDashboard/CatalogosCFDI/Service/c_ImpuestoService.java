package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Impuesto;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ImpuestoRepository;

@Service
public class c_ImpuestoService{
    @Autowired
    c_ImpuestoRepository cImpuestoRepository; 

    public List<c_Impuesto> getAllImpuestoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Impuesto> impuesto = cImpuestoRepository.findDataByStatus(status, sort);
        return impuesto;
    }
}
