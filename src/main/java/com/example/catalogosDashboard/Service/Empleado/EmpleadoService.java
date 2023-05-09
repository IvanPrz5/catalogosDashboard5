package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpleadoEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<EmpleadoEntity> getAllEmpleadosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<EmpleadoEntity> empleado = empleadoRepository.findDataByStatus(status, sort);
        return empleado;
    }
}