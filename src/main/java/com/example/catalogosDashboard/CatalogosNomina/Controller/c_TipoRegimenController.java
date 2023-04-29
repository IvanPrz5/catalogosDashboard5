package com.example.catalogosDashboard.CatalogosNomina.Controller;

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

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoRegimenEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoRegimenRepository;
import com.example.catalogosDashboard.CatalogosNomina.Service.c_TipoRegimenService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoRegimen")
public class c_TipoRegimenController {

    @Autowired
    private c_TipoRegimenService cTipoRegimenService;

    @Autowired
    private c_TipoRegimenRepository cTipoRegimenRepository;

    /* @GetMapping
    public List<c_TipoRegimenEntity> getAllData(){
        return (List<c_TipoRegimenEntity>) cTipoRegimenService.getAllRegimen();    
    } */ 

    @GetMapping(value = "/{id}")
    public Optional<c_TipoRegimenEntity> getDataByIdTipoRegimen(@PathVariable("id") String id) {
        return cTipoRegimenService.getTipoRegimenById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoRegimenEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoRegimenEntity>) cTipoRegimenService.getAllTipoRegimenByStatus(status, sort);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<c_TipoRegimenEntity> createRegistro(@RequestBody c_TipoRegimenEntity var) {
        try {
            c_TipoRegimenEntity tipoRegimen = cTipoRegimenRepository.save(var);
            return new ResponseEntity<>(tipoRegimen, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoRegimenEntity> updatingRegistro(@PathVariable("id") String idTipoRegimen, @RequestBody c_TipoRegimenEntity cTipoRegimen){
        Optional<c_TipoRegimenEntity> tipoRegimenData = cTipoRegimenRepository.findById(idTipoRegimen);
        
        if(tipoRegimenData.isPresent()){
            c_TipoRegimenEntity tipoRegimen = cTipoRegimenRepository.save(cTipoRegimen);
            return new ResponseEntity<>(tipoRegimen, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoRegimenEntity> updatingStatus(@PathVariable("id") String idTipoRegimen, @RequestBody c_TipoRegimenEntity cTipoRegimen){
        Optional<c_TipoRegimenEntity> tipoRegimenData = cTipoRegimenRepository.findById(idTipoRegimen);
        
        if(tipoRegimenData.isPresent()){
            c_TipoRegimenEntity tipoRegimen =  tipoRegimenData.get();;
            tipoRegimen.setStatus(cTipoRegimen.getStatus());
            return new ResponseEntity<>(cTipoRegimenRepository.save(tipoRegimen),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }   
    }
}