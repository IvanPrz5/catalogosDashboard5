package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresasRepository;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;

@Service
public class SubEmpresasService {
    
    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    @Autowired
    EmpresasRepository empresasRepository;

    public List<SubEmpresasEntity> getAllSubEmpresasByIdEmpresaAndStatus(Long idEmpresa, Boolean status, Sort sort){
        Optional<EmpresasEntity> empresasEntity = empresasRepository.findById(idEmpresa);
        EmpresasEntity empresaId = empresasEntity.get();
        sort = Sort.by("id");
        List<SubEmpresasEntity> subEmpresas = subEmpresasRepository.findDataByIdEmpresaAndStatus(empresaId, status, sort);
        return subEmpresas;
    }
}
