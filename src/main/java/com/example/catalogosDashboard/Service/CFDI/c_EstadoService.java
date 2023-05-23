package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Entity.CFDI.c_Pais;
import com.example.catalogosDashboard.Repository.CFDI.c_EstadoRepository;
import com.example.catalogosDashboard.Repository.CFDI.c_PaisRepository;

@Service
public class c_EstadoService {
    @Autowired
    c_EstadoRepository cEstadoRepository; 

    @Autowired
    c_PaisRepository paisRepository;

    public List<c_Estado> getAllEstadoByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<c_Estado> estado = cEstadoRepository.findDataByStatus(status, sort);
        return estado;
    }

    public List<c_Estado> getByIdPaisAndStatus(String id, Boolean status, Sort sort){
        Optional<c_Pais> paisEntity = paisRepository.findById(id);
        c_Pais idPais = paisEntity.get();
        sort = Sort.by("id");

        List<c_Estado> estado = cEstadoRepository.findByIdPaisAndStatus(idPais, status, sort);
        return estado;
    }
}
