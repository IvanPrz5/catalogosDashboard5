package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.EmpresasEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpresasRepository;

@Service
public class EmpresasService {
    @Autowired
    EmpresasRepository empresasRepository;

    public List<EmpresasEntity> getAllEmpresasByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpresasEntity> empresas = empresasRepository.findDataByStatus(status, sort);
        return empresas;
    }
}
