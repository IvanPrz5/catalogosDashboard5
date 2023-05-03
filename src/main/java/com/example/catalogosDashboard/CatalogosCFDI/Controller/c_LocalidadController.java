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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Localidad;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_LocalidadRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_LocalidadService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Localidad")
public class c_LocalidadController {
    @Autowired
    private c_LocalidadRepository cLocalidadRepository;

    @Autowired
    private c_LocalidadService cLocalidadService;

    /* @GetMapping
    public List<c_Localidad> getAllData() {
        return (List<c_Localidad>) cLocalidadRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Localidad> data(@PathVariable("id") String id) {
        return cLocalidadRepository.findById(id);
    }

    @Transactional
    @GetMapping("/relation/{idEstado}/{status}")
    public List<c_Localidad> getDataByEstadoAndStatus(@PathVariable("idEstado") String idEstado, @PathVariable("status") Boolean status){
        return (List<c_Localidad>) cLocalidadService.getByEstadoAndStatus(idEstado, status);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Localidad> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Localidad>) cLocalidadService.getAllLocalidadByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Localidad> createRegistro(@RequestBody c_Localidad var) {
        try {
            c_Localidad localidad = cLocalidadRepository.save(var);
            return new ResponseEntity<>(localidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Localidad> updatingRegistro(@PathVariable("id") String idLocalidad, @RequestBody c_Localidad cLocalidad){
        Optional<c_Localidad> localidadData = cLocalidadRepository.findById(idLocalidad);
        
        if(localidadData.isPresent()){
            c_Localidad localidad = localidadData.get();
            localidad.setDescripcion(cLocalidad.getDescripcion());
            localidad.setStatus(cLocalidad.getStatus());
            return new ResponseEntity<>(cLocalidadRepository.save((localidad)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Localidad> updatingStatus(@PathVariable("id") String idLocalidad, @RequestBody c_Localidad cLocalidad){
        Optional<c_Localidad> localidadData = cLocalidadRepository.findById(idLocalidad);
        
        if(localidadData.isPresent()){
            c_Localidad localidad = localidadData.get();
            localidad.setStatus(cLocalidad.getStatus());
            return new ResponseEntity<>(cLocalidadRepository.save(localidad),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
