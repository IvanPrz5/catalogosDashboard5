package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Estado;
import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Localidad;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_EstadoRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_LocalidadRepository;

@Service
public class c_LocalidadService {

    @Autowired
    c_LocalidadRepository cLocalidadRepository; 

    @Autowired
    c_EstadoRepository cEstadoRepository;

    public List<c_Localidad> getAllLocalidadByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Localidad> localidad = cLocalidadRepository.findDataByStatus(status, sort);
        return localidad;
    }

    public List<c_Localidad> getByEstadoAndStatus(String idEstado, Boolean status){
        Optional<c_Estado> estado = cEstadoRepository.findById(idEstado);
        c_Estado estadoId = estado.get();
        return cLocalidadRepository.findByEstadoAndStatus(estadoId, status);
    }
}
