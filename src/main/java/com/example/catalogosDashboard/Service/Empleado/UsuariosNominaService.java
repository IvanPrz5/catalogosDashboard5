package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.UsuariosNominaEntity;
import com.example.catalogosDashboard.Repository.Empleado.UsuariosNominaRepository;

@Service
public class UsuariosNominaService {
    @Autowired
    UsuariosNominaRepository usuariosNominaRepository;

    public List<UsuariosNominaEntity> getAllUsuariosNominaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<UsuariosNominaEntity> usuariosNomina = usuariosNominaRepository.findByStatus(status, sort);
        return usuariosNomina;
    }
}
