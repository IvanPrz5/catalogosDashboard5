package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpleadoEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpleadoRepository;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    public List<EmpleadoEntity> getAllEmpleadosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpleadoEntity> empleado = empleadoRepository.findDataByStatus(status, sort);
        return empleado;
    }

    public List<EmpleadoEntity> getAllEmpleadosByIdSubEmpresaAndStatus(Long id, Boolean status, Sort sort){
        Optional<SubEmpresasEntity> subEmpresasEntity = subEmpresasRepository.findById(id);
        SubEmpresasEntity subEmpresaId = subEmpresasEntity.get();

        sort = Sort.by("id");
        List<EmpleadoEntity> empleado = empleadoRepository.findByIdSubEmpresaAndStatus(subEmpresaId, status, sort);
        return empleado;
    }
}