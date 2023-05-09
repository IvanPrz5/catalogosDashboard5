package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;
import com.example.catalogosDashboard.Repository.CFDI.c_CodigoPostalRepository;

@Service
public class c_CodigoPostalService {
    @Autowired
    c_CodigoPostalRepository cCodigoPostalRepository; 

    public List<c_CodigoPostal> getAllCodigoPostalByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_CodigoPostal> codigoPostal = cCodigoPostalRepository.findDataByStatus(status, sort);
        return codigoPostal;
    }
}
