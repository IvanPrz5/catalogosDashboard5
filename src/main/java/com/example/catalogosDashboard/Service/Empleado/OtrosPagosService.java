package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.OtrosPagosEntity;
import com.example.catalogosDashboard.Repository.Empleado.OtrosPagosRepository;

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
