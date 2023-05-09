package com.example.catalogosDashboard.Repository.CFDI;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.CFDI.c_NumPedAduana;

public interface c_NumPedAduanaRepository extends JpaRepository <c_NumPedAduana, Integer>{
    List<c_NumPedAduana> findDataByStatus(Boolean status, Sort sort);
}
