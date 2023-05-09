package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_RegimenFiscal;
import com.example.catalogosDashboard.Repository.CFDI.c_RegimenFiscalRepository;

@Service
public class c_RegimenFiscalService {
    @Autowired
    c_RegimenFiscalRepository cRegimenFiscalRepository; 

    public List<c_RegimenFiscal> getAllRegimenFiscalByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_RegimenFiscal> objetoImp = cRegimenFiscalRepository.findDataByStatus(status, sort);
        return objetoImp;
    }   
}
