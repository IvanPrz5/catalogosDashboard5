package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_MetodoPago;
import com.example.catalogosDashboard.Repository.CFDI.c_MetodoPagoRepository;

@Service
public class c_MetodoPagoService {
    @Autowired
    c_MetodoPagoRepository cMetodoPagoRepository; 

    public List<c_MetodoPago> getAllMetodoPagoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_MetodoPago> metodoPago = cMetodoPagoRepository.findDataByStatus(status, sort);
        return metodoPago;
    }
}
