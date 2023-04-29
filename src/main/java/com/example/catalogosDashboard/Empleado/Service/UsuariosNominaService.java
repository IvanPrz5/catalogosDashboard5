package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.UsuariosNominaEntity;
import com.example.catalogosDashboard.Empleado.Repository.UsuariosNominaRepository;

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
