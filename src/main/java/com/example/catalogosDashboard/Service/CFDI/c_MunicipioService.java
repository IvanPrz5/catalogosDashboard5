package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Entity.CFDI.c_Municipio;
import com.example.catalogosDashboard.Repository.CFDI.c_EstadoRepository;
import com.example.catalogosDashboard.Repository.CFDI.c_MunicipioRepository;


@Service
public class c_MunicipioService {
    @Autowired
    c_MunicipioRepository cMunicipioRepository; 

    @Autowired
    c_EstadoRepository cEstadoRepository; 

    public List<c_Municipio> getAllMunicipioByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Municipio> municipio = cMunicipioRepository.findDataByStatus(status, sort);
        return municipio;
    }

    public List<c_Municipio> getByEstadoAndStatus(String idEstado, Boolean status){
        Optional<c_Estado> estado = cEstadoRepository.findById(idEstado);
        c_Estado estadoId = estado.get();
        return cMunicipioRepository.findByEstadoAndStatus(estadoId, status);
    }
}
