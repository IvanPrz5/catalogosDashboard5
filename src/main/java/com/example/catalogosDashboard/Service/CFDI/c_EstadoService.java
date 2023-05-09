package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Repository.CFDI.c_EstadoRepository;

@Service
public class c_EstadoService {
    @Autowired
    c_EstadoRepository cEstadoRepository; 

    public List<c_Estado> getAllEstadoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Estado> estado = cEstadoRepository.findDataByStatus(status, sort);
        return estado;
    }
}
