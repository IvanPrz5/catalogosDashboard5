package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Moneda;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_MonedaRepository;

@Service
public class c_MonedaService {
    @Autowired
    c_MonedaRepository cMonedaRepository; 

    public List<c_Moneda> getAllMonedaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Moneda> Moneda = cMonedaRepository.findDataByStatus(status, sort);
        return Moneda;
    }
}
