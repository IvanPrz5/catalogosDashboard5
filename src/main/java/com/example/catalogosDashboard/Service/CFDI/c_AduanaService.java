package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_Aduana;
import com.example.catalogosDashboard.Repository.CFDI.c_AduanaRepository;

@Service
public class c_AduanaService {
    
    @Autowired
    c_AduanaRepository cAduanaRepository; 

    public List<c_Aduana> getAllAduanaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Aduana> aduana = cAduanaRepository.findDataByStatus(status, sort);
        return aduana;
    }

    /* public Optional<c_Aduana> getAduanaById(String id){
        return cAduanaRepository.findById(id);        
    } */
}
