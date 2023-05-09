package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.SindicatoEntity;
import com.example.catalogosDashboard.Repository.Empleado.SindicatoRepository;

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
