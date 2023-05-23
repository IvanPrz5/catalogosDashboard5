package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;
import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Repository.CFDI.c_CodigoPostalRepository;
import com.example.catalogosDashboard.Repository.CFDI.c_EstadoRepository;

@Service
public class c_CodigoPostalService {
    @Autowired
    c_CodigoPostalRepository cCodigoPostalRepository; 

    @Autowired
    c_EstadoRepository estadoRepository;

    public List<c_CodigoPostal> getAllCodigoPostalByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_CodigoPostal> codigoPostal = cCodigoPostalRepository.findDataByStatus(status, sort);
        return codigoPostal;
    }

    public Optional<c_CodigoPostal> getByIdAndStatus(String id, Boolean status, Sort sort){
        sort = Sort.by("id");
        Optional<c_CodigoPostal> codigoPostal = cCodigoPostalRepository.findByIdAndStatus(id, status, sort);
        return codigoPostal;
    }

    public List<c_CodigoPostal> getByIdEstadoAndStatus(String id, Boolean status, Sort sort){
        Optional<c_Estado> estadoEntity = estadoRepository.findById(id);
        c_Estado idEstado = estadoEntity.get();
        
        sort = Sort.by("id");
        List<c_CodigoPostal> codigoPostal = cCodigoPostalRepository.findByIdEstadoAndStatus(idEstado, status, sort);
        return codigoPostal;
    }
}
