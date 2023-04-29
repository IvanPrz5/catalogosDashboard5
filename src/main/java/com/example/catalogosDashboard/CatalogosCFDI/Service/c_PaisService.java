package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Pais;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_PaisRepository;

@Service
public class c_PaisService {
    @Autowired
    c_PaisRepository cPaisRepository; 

    public List<c_Pais> getAllPaisByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Pais> pais = cPaisRepository.findDataByStatus(status, sort);
        return pais;
    }
}
