package com.example.catalogosDashboard.Service.CFDI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.CFDI.c_Asentamientos;
import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;
import com.example.catalogosDashboard.Repository.CFDI.c_AsentamientosRepository;
import com.example.catalogosDashboard.Repository.CFDI.c_CodigoPostalRepository;

@Service
public class c_AsentamientosService {
    @Autowired
    c_AsentamientosRepository cAsentamientosRepository;
    
    @Autowired
    c_CodigoPostalRepository codigoPostalRepository;

    public Page<c_Asentamientos> paginas(Integer page, Integer size, Boolean enablePagination) {
        return cAsentamientosRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    public List<c_Asentamientos> getByIdCodigoPostalAndStatus(String id, Boolean status, Sort sort){
        Optional<c_CodigoPostal> codigoPostalEntity = codigoPostalRepository.findById(id);
        c_CodigoPostal idCodPostal = codigoPostalEntity.get();
        
        sort = Sort.by("id");
        List<c_Asentamientos> asentamientos = cAsentamientosRepository.findByIdCodigoPostalAndStatus(idCodPostal, status, sort);
        return asentamientos;
    }

    /* public List<c_Asentamientos> getAllAsentamientosByStatus(Boolean status, int pageable){
        // sort = Sort.by("id");
        Pageable page = PageRequest.of(pageable, 50);
        List<c_Asentamientos> asentamientos = cAsentamientosRepository.findDataByStatus(status, page);
        return asentamientos;
    } */
}
