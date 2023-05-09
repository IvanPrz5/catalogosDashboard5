package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpresaDeduccionEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresaDeduccionRepository;
@Service
public class EmpresaDeduccionService {
    
    @Autowired
    EmpresaDeduccionRepository empresaDeduccionRepository;

    public List<EmpresaDeduccionEntity> getAllEmpresaDeduccionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpresaDeduccionEntity> empresaDeduccion = empresaDeduccionRepository.findByStatus(status, sort);
        return empresaDeduccion;
    }
}
