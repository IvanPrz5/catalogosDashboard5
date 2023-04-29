package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_UsoCFDI;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_UsoCFDIRepository;

@Service
public class c_UsoCFDIService {
    @Autowired
    c_UsoCFDIRepository cUsoCFDIRepository; 

    public List<c_UsoCFDI> getAllUsoCFDIByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_UsoCFDI> usoCFDI = cUsoCFDIRepository.findDataByStatus(status, sort);
        return usoCFDI;
    }  
}
