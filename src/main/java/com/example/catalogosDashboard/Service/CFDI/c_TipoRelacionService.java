package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_TipoRelacion;
import com.example.catalogosDashboard.Repository.CFDI.c_TipoRelacionRepository;

@Service
public class c_TipoRelacionService {
    @Autowired
    c_TipoRelacionRepository cTipoRelacionRepository; 

    public List<c_TipoRelacion> getAllTipoRelacionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TipoRelacion> tipoRelacion = cTipoRelacionRepository.findDataByStatus(status, sort);
        return tipoRelacion;
    }  
}
