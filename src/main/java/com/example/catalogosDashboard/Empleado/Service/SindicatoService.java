package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.SindicatoEntity;
import com.example.catalogosDashboard.Empleado.Repository.SindicatoRepository;

@Service
public class SindicatoService {
    
    @Autowired
    SindicatoRepository sindicatoRepository;

    public List<SindicatoEntity> getAllSindicatoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<SindicatoEntity> sindicato = sindicatoRepository.findDataByStatus(status, sort);
        return sindicato;
    }
}
