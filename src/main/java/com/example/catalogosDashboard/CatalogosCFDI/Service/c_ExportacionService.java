package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Exportacion;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ExportacionRepository;

@Service
public class c_ExportacionService {
    @Autowired
    c_ExportacionRepository cExportacionRepository; 

    public List<c_Exportacion> getAllExportacionByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Exportacion> exportacion = cExportacionRepository.findDataByStatus(status, sort);
        return exportacion;
    }
}
