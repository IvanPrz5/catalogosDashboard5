package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_ObjetoImp;

public interface c_ObjetoImpRepository extends JpaRepository <c_ObjetoImp, String> {
    List<c_ObjetoImp> findDataByStatus(Boolean status, Sort sort);
    
}
