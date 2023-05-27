package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.PeriodosEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.PeriodosRepository;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;

@Service
public class PeriodosService {
    @Autowired
    PeriodosRepository periodosRepository;

    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    public List<PeriodosEntity> getAllPeriodosByStatus(Boolean status, Sort sort) {
        sort = Sort.by("id");
        List<PeriodosEntity> periodos = periodosRepository.findByStatus(status, sort);
        return periodos;
    }

    public List<String> getByIdSubEmpresa(Long id) {
        Optional<SubEmpresasEntity> subEmpresas = subEmpresasRepository.findById(id);
        SubEmpresasEntity idSubEmpresa = subEmpresas.get();
        List<String> periodos = periodosRepository.queryByIdSubEmpresa(idSubEmpresa);
        return periodos;
    }

    public List<String> getByIdSubEmpresaAndYear(Long id, String year) {
        Optional<SubEmpresasEntity> subEmpresas = subEmpresasRepository.findById(id);
        SubEmpresasEntity idSubEmpresa = subEmpresas.get();
        List<String> periodos = periodosRepository.queryByIdSubEmpresaAndYear(idSubEmpresa, year);
        return periodos;
    }

    public List<PeriodosEntity> getByYearAndMonthAndIdSubEmpresa(String year, String month, Long id) {
        Optional<SubEmpresasEntity> subEmpresas = subEmpresasRepository.findById(id);
        SubEmpresasEntity idSubEmpresa = subEmpresas.get();
        List<PeriodosEntity> periodos = periodosRepository.queryByYearAndMonthAndIdSubEmpresa(year, month, idSubEmpresa);
        return periodos;
    }
}
