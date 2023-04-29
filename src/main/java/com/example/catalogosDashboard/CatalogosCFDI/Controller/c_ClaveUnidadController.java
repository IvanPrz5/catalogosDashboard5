package com.example.catalogosDashboard.CatalogosCFDI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ClaveUnidad;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ClaveUnidadRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_ClaveUnidadService;

import java.util.List;
import java.util.Optional;;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/ClaveUnidad")
public class c_ClaveUnidadController {
    
    @Autowired
    private c_ClaveUnidadRepository cClaveUnidadRepository;

    @Autowired
    private c_ClaveUnidadService cClaveUnidadService;

    /* @GetMapping
    public List<c_ClaveUnidad> getAllData() {
        return (List<c_ClaveUnidad>) claveunidadRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_ClaveUnidad> data(@PathVariable("id") String id) {
        return cClaveUnidadRepository.findById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_ClaveUnidad> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_ClaveUnidad>) cClaveUnidadService.getAllClaveUnidadByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_ClaveUnidad> createRegistro(@RequestBody c_ClaveUnidad var) {
        try {
            c_ClaveUnidad claveUnidad = cClaveUnidadRepository.save(var);
            return new ResponseEntity<>(claveUnidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_ClaveUnidad> updatingRegistro(@PathVariable("id") String idClaveUnidad, @RequestBody c_ClaveUnidad cClaveUnidad){
        Optional<c_ClaveUnidad> claveUnidadData = cClaveUnidadRepository.findById(idClaveUnidad);
        
        if(claveUnidadData.isPresent()){
            c_ClaveUnidad claveUnidad =  claveUnidadData.get();
            claveUnidad.setDescripcion(cClaveUnidad.getDescripcion());
            claveUnidad.setNombre(cClaveUnidad.getNombre());
            claveUnidad.setSimbolo(cClaveUnidad.getSimbolo());
            claveUnidad.setStatus(cClaveUnidad.getStatus());
            return new ResponseEntity<>(cClaveUnidadRepository.save(claveUnidad), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_ClaveUnidad> updatingStatus(@PathVariable("id") String idClaveUnidad, @RequestBody c_ClaveUnidad cClaveUnidad){
        Optional<c_ClaveUnidad> claveUnidadData = cClaveUnidadRepository.findById(idClaveUnidad);
        
        if(claveUnidadData.isPresent()){
            c_ClaveUnidad claveUnidad =  claveUnidadData.get();
            claveUnidad.setStatus(cClaveUnidad.getStatus());
            return new ResponseEntity<>(cClaveUnidadRepository.save(claveUnidad),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
