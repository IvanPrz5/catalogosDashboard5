package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_TasaoCuota;
import com.example.catalogosDashboard.Repository.CFDI.c_TasaoCuotaRepository;

@Service
public class c_TasaoCuotaService {
    @Autowired
    c_TasaoCuotaRepository cTasaoCoutaRepository; 

    public List<c_TasaoCuota> getAllTasaoCoutaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_TasaoCuota> tasaoCouta = cTasaoCoutaRepository.findDataByStatus(status, sort);
        return tasaoCouta;
    }
}
