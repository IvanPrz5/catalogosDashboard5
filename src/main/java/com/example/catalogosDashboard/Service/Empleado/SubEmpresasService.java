package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;

@Service
public class SubEmpresasService {
    
    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    public List<SubEmpresasEntity> getAllSubEmpresasByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<SubEmpresasEntity> subEmpresas = subEmpresasRepository.findDataByStatus(status, sort);
        return subEmpresas;
    }
}
