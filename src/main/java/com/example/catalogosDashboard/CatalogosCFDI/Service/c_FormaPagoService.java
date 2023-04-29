package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_FormaPago;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_FormaPagoRepository;

@Service
public class c_FormaPagoService {
    @Autowired
    c_FormaPagoRepository cFormaPagoRepository; 

    public List<c_FormaPago> getAllFormaPagoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_FormaPago> formaPago = cFormaPagoRepository.findDataByStatus(status, sort);
        return formaPago;
    }
}
