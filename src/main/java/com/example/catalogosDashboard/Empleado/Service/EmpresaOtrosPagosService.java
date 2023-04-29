package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.EmpresaOtrosPagosEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpresaOtrosPagosRepository;

@Service
public class EmpresaOtrosPagosService {
    
    @Autowired
    EmpresaOtrosPagosRepository empresaOtrosPagosRepository;

    public List<EmpresaOtrosPagosEntity> getAllEmpresaOtrosPagosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpresaOtrosPagosEntity> empresaOtrosPagos = empresaOtrosPagosRepository.findByStatus(status, sort);
        return empresaOtrosPagos;
    }
}
