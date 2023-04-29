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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TipoFactor;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_TipoFactorRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_TipoFactorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoFactor")
public class c_TipoFactorController {
    @Autowired
    private c_TipoFactorRepository tipoFactorRepository;

    @Autowired
    private c_TipoFactorService tipoFactorService;

    /* @GetMapping
    public List<c_TipoFactor> getAllData() {
        return (List<c_TipoFactor>) tipofactorRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoFactor> data(@PathVariable("id") String id) {
        return tipoFactorRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_TipoFactor> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoFactor>) tipoFactorService.getAllTipoFactorByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoFactor> createRegistro(@RequestBody c_TipoFactor var) {
        try {
            c_TipoFactor tipoFactor = tipoFactorRepository.save(var);
            return new ResponseEntity<>(tipoFactor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoFactor> updatingRegistro(@PathVariable("id") String idTipoFac, @RequestBody c_TipoFactor cTipoFac){
        Optional<c_TipoFactor> tipoFacData = tipoFactorRepository.findById(idTipoFac);
        
        if(tipoFacData.isPresent()){
            c_TipoFactor tipoFactor = tipoFacData.get();
            tipoFactor.setStatus(cTipoFac.getStatus());
            return new ResponseEntity<>(tipoFactorRepository.save((tipoFactor)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoFactor> updatingStatus(@PathVariable("id") String idTipoFac, @RequestBody c_TipoFactor cTipoFac){
        Optional<c_TipoFactor> tipoFacData = tipoFactorRepository.findById(idTipoFac);
        
        if(tipoFacData.isPresent()){
            c_TipoFactor tipoFactor = tipoFacData.get();
            tipoFactor.setStatus(cTipoFac.getStatus());
            return new ResponseEntity<>(tipoFactorRepository.save(tipoFactor),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
