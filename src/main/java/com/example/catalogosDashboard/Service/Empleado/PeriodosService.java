package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.PeriodosEntity;
import com.example.catalogosDashboard.Repository.Empleado.PeriodosRepository;

@Service
public class PeriodosService {
    @Autowired
    PeriodosRepository periodosRepository;

    public List<PeriodosEntity> getAllPeriodosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<PeriodosEntity> periodos = periodosRepository.findByStatus(status, sort);
        return periodos;
    }
}
