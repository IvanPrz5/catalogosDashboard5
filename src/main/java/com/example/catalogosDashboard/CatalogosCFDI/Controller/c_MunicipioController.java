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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Municipio;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_MunicipioRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_MunicipioService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Municipio")
public class c_MunicipioController {
    @Autowired
    private c_MunicipioRepository cMunicipioRepository;

    @Autowired
    private c_MunicipioService cMunicipioService;

    /* @GetMapping
    public List<c_Municipio> getAllData() {
        return (List<c_Municipio>) municipioRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Municipio> data(@PathVariable("id") String id) {
        return cMunicipioRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Municipio> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Municipio>) cMunicipioService.getAllMunicipioByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Municipio> createRegistro(@RequestBody c_Municipio var) {
        try {
            c_Municipio municipio = cMunicipioRepository.save(var);
            return new ResponseEntity<>(municipio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Municipio> updatingRegistro(@PathVariable("id") String idMunicipio, @RequestBody c_Municipio cMunicipio){
        Optional<c_Municipio> municipioData = cMunicipioRepository.findById(idMunicipio);
        
        if(municipioData.isPresent()){
            c_Municipio municipio = municipioData.get();
            municipio.setDescripcion(cMunicipio.getDescripcion());
            municipio.setStatus(cMunicipio.getStatus());
            return new ResponseEntity<>(cMunicipioRepository.save((municipio)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Municipio> updatingStatus(@PathVariable("id") String idMunicipio, @RequestBody c_Municipio cMunicipio){
        Optional<c_Municipio> municipioData = cMunicipioRepository.findById(idMunicipio);
        
        if(municipioData.isPresent()){
            c_Municipio municipio = municipioData.get();
            municipio.setStatus(cMunicipio.getStatus());
            return new ResponseEntity<>(cMunicipioRepository.save(municipio),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
