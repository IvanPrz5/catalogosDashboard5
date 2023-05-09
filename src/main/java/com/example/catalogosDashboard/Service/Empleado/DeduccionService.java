package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.DeduccionEntity;
import com.example.catalogosDashboard.Repository.Empleado.DeduccionRepository;

@Service
public class DeduccionService {
    @Autowired
    DeduccionRepository deduccionRepository;

    public List<DeduccionEntity> getAllDeduccionesByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<DeduccionEntity> deduccion = deduccionRepository.findDataByStatus(status, sort);
        return deduccion;
    }
}
