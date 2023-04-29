package com.example.catalogosDashboard.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Empleado.Entity.PeriodosEntity;
import com.example.catalogosDashboard.Empleado.Repository.PeriodosRepository;

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
