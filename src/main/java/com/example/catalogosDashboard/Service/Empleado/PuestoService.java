package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.PuestoEntity;
import com.example.catalogosDashboard.Repository.Empleado.PuestoRepository;

@Service
public class PuestoService {
    @Autowired
    PuestoRepository puestoRepository;

    public List<PuestoEntity> getAllPuestoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<PuestoEntity> puesto = puestoRepository.findDataByStatus(status, sort);
        return puesto;
    }
}
