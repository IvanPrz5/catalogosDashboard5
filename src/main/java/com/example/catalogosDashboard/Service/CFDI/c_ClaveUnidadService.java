package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_ClaveUnidad;
import com.example.catalogosDashboard.Repository.CFDI.c_ClaveUnidadRepository;

@Service
public class c_ClaveUnidadService {
    @Autowired
    c_ClaveUnidadRepository cClaveUnidadRepository; 

    public List<c_ClaveUnidad> getAllClaveUnidadByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_ClaveUnidad> claveUnidad = cClaveUnidadRepository.findDataByStatus(status, sort);
        return claveUnidad;
    }
}
