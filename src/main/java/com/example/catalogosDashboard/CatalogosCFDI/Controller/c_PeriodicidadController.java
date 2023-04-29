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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Periodicidad;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_PeriodicidadRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_PeriodicidadService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Periodicidad")
public class c_PeriodicidadController {
    @Autowired
    private c_PeriodicidadRepository cPeriodicidadRepository;

    @Autowired
    private c_PeriodicidadService cPeriodicidadService;

    /* @GetMapping
    public List<c_Periodicidad> getAllData() {
        return (List<c_Periodicidad>) cPeriodicidadRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Periodicidad> data(@PathVariable("id") String id) {
        return cPeriodicidadRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Periodicidad> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Periodicidad>) cPeriodicidadService.getAllPeriodicidadByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Periodicidad> createRegistro(@RequestBody c_Periodicidad var) {
        try {
            c_Periodicidad periodicidad = cPeriodicidadRepository.save(var);
            return new ResponseEntity<>(periodicidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Periodicidad> updatingRegistro(@PathVariable("id") String idPeriodicidad, @RequestBody c_Periodicidad cPeriodicidad){
        Optional<c_Periodicidad> periodicidadData = cPeriodicidadRepository.findById(idPeriodicidad);
        
        if(periodicidadData.isPresent()){
            c_Periodicidad periodicidad =  periodicidadData.get();
            periodicidad.setDescripcion(cPeriodicidad.getDescripcion());
            periodicidad.setStatus(cPeriodicidad.getStatus());
            return new ResponseEntity<>(cPeriodicidadRepository.save(periodicidad), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Periodicidad> updatingStatus(@PathVariable("id") String idPeriodicidad, @RequestBody c_Periodicidad cPeriodicidad){
        Optional<c_Periodicidad> periodicidadData = cPeriodicidadRepository.findById(idPeriodicidad);
        
        if(periodicidadData.isPresent()){
            c_Periodicidad periodicidad =  periodicidadData.get();
            periodicidad.setStatus(cPeriodicidad.getStatus());
            return new ResponseEntity<>(cPeriodicidadRepository.save(periodicidad), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
