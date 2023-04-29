package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TipoComp;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_TipoCompRepository;

@Service
public class c_TipoCompService {
    @Autowired
    c_TipoCompRepository cTipoCompRepository; 

    public List<c_TipoComp> getAllTipoCompByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoComp> tipoComp = cTipoCompRepository.findDataByStatus(status, sort);
        return tipoComp;
    }  
}
