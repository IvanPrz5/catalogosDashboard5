package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_PatenteAduanal;
import com.example.catalogosDashboard.Repository.CFDI.c_PatenteAduanalRepository;

@Service
public class c_PatenteAduanalService {
    @Autowired
    c_PatenteAduanalRepository cPatenteAduanalRepository; 

    public List<c_PatenteAduanal> getAllPatenteAduanalByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_PatenteAduanal> patenteAduanal = cPatenteAduanalRepository.findDataByStatus(status, sort);
        return patenteAduanal;
    }
}
