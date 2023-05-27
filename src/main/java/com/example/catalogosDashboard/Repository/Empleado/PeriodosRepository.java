package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.catalogosDashboard.Entity.Empleado.PeriodosEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public interface PeriodosRepository extends JpaRepository<PeriodosEntity, Long> {
    List<PeriodosEntity> findByStatus(Boolean status, Sort sort);

    @Query("SELECT EXTRACT(year FROM pago) AS year FROM PeriodosEntity p WHERE p.idSubEmpresa = ?1 GROUP BY EXTRACT(year FROM pago)")
    List<String> queryByIdSubEmpresa(SubEmpresasEntity id);

    @Query("SELECT EXTRACT(month FROM pago) AS month FROM PeriodosEntity p WHERE p.idSubEmpresa = ?1 AND EXTRACT(year FROM pago) = ?2 GROUP BY EXTRACT(month FROM pago)")
    List<String> queryByIdSubEmpresaAndYear(SubEmpresasEntity id, String año);

    @Query("SELECT p FROM PeriodosEntity p where EXTRACT(year from pago) = ?1 AND extract(month from pago) = ?2 AND p.idSubEmpresa = ?3")
    List<PeriodosEntity> queryByYearAndMonthAndIdSubEmpresa(String year, String month, SubEmpresasEntity id);    
}
