package com.example.catalogosDashboard.CatalogosCFDI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Asentamientos;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_AsentamientosRepository;

@Service
public class c_AsentamientosService {
    @Autowired
    c_AsentamientosRepository cAsentamientosRepository; 

    public Page<c_Asentamientos> paginas(Integer page, Integer size, Boolean enablePagination) {
        return cAsentamientosRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    /* public List<c_Asentamientos> getAllAsentamientosByStatus(Boolean status, int pageable){
        // sort = Sort.by("id");
        Pageable page = PageRequest.of(pageable, 50);
        List<c_Asentamientos> asentamientos = cAsentamientosRepository.findDataByStatus(status, page);
        return asentamientos;
    } */
}
