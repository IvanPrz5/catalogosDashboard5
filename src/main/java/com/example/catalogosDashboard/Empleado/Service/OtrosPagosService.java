package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.OtrosPagosEntity;
import com.example.catalogosDashboard.Empleado.Repository.OtrosPagosRepository;

@Service
public class OtrosPagosService {
    @Autowired
    OtrosPagosRepository otrosPagosRepository;

    public List<OtrosPagosEntity> getAllOtrosPagosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<OtrosPagosEntity> otrosPagos = otrosPagosRepository.findByStatus(status, sort);
        return otrosPagos;
    }
}
