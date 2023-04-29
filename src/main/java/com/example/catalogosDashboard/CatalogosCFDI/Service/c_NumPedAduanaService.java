package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_NumPedAduana;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_NumPedAduanaRepository;

@Service
public class c_NumPedAduanaService {
    @Autowired
    c_NumPedAduanaRepository cNumPedAduanaRepository; 

    public List<c_NumPedAduana> getAllNumPedAduanaByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_NumPedAduana> numPedAduana = cNumPedAduanaRepository.findDataByStatus(status, sort);
        return numPedAduana;
    }
}
