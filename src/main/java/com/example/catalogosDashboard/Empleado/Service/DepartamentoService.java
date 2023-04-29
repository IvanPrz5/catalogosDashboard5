package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.DepartamentoEntity;
import com.example.catalogosDashboard.Empleado.Repository.DepartamentoRepository;

@Service
public class DepartamentoService {
    
    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<DepartamentoEntity> getAllDepartamentoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<DepartamentoEntity> departamento = departamentoRepository.findDataByStatus(status, sort);
        return departamento;
    }
}
