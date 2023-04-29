package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.EmpresaPercepcionEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpresaPercepcionRepository;

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
