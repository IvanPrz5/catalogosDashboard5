package com.example.catalogosDashboard.CatalogosNomina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_BancoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_BancoRepository;

@Service
public class c_BancoService {

    @Autowired
    c_BancoRepository cbancoRepository; 

    public List<c_BancoEntity> getAllBancosByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_BancoEntity> banco = cbancoRepository.findDataByStatus(status, sort);
        return banco;
    }

    public Optional<c_BancoEntity> getBancoById(String id){
        return cbancoRepository.findById(id);        
    }
}
