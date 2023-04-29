package com.example.catalogosDashboard.Empleado.Service;

import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.PercepcionesEntity;
import com.example.catalogosDashboard.Empleado.Repository.PercepcionesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@Service
public class PercepcionesService {
    @Autowired
    PercepcionesRepository percepcionesRepository;

    public List<PercepcionesEntity> getAllPercepcionesByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<PercepcionesEntity> percepciones = percepcionesRepository.findByStatus(status, sort);
        return percepciones;
    }
}
