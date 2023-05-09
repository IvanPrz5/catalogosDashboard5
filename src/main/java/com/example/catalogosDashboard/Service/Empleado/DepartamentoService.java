package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.DepartamentoEntity;
import com.example.catalogosDashboard.Repository.Empleado.DepartamentoRepository;

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
