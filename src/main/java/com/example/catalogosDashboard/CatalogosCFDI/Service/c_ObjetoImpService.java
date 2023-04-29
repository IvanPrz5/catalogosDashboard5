package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ObjetoImp;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ObjetoImpRepository;


@Service
public class c_ObjetoImpService {
    @Autowired
    c_ObjetoImpRepository cObjetoImpRepository; 

    public List<c_ObjetoImp> getAllObjetoImpByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_ObjetoImp> objetoImp = cObjetoImpRepository.findDataByStatus(status, sort);
        return objetoImp;
    }
}
