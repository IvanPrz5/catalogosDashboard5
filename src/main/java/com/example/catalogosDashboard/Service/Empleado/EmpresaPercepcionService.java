package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpresaPercepcionEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresaPercepcionRepository;

@Service
public class EmpresaPercepcionService {
    @Autowired
    EmpresaPercepcionRepository empresaPercepcionRepository;

    public List<EmpresaPercepcionEntity> getAllEmpresaPercepcionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpresaPercepcionEntity> empresaPercepcion = empresaPercepcionRepository.findByStatus(status, sort);
        return empresaPercepcion;
    }
}
