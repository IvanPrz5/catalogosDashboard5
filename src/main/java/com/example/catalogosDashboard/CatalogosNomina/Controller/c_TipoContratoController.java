package com.example.catalogosDashboard.CatalogosNomina.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoContratoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoContratoRepository;
import com.example.catalogosDashboard.CatalogosNomina.Service.c_TipoContratoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoContrato")
public class c_TipoContratoController {

    @Autowired
    private c_TipoContratoService cTipoContratoService;

    @Autowired
    private c_TipoContratoRepository cTipoContratoRepository;

    /* @GetMapping
    public List<c_TipoContratoEntity> getAllData(){
        return (List<c_TipoContratoEntity>) cTipoContratoService.getAllTipoContrato();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoContratoEntity> getDataByIdTipoContrato(@PathVariable("id") String id) {
        return cTipoContratoService.getTipoContratoById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoContratoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoContratoEntity>) cTipoContratoService.getAllTipoContratoByStatus(status, sort);
    }

    @PostMapping("agregar")
    public ResponseEntity<c_TipoContratoEntity> createRegistro(@RequestBody c_TipoContratoEntity var) {
        try {
            c_TipoContratoEntity tipoContrato = cTipoContratoRepository.save(var);
            return new ResponseEntity<>(tipoContrato, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoContratoEntity> updatingRegistro(@PathVariable("id") String idTipoContrato, @RequestBody c_TipoContratoEntity cTipoContrato){
        Optional<c_TipoContratoEntity> tipoContratoData = cTipoContratoRepository.findById(idTipoContrato);
        
        if(tipoContratoData.isPresent()){
            c_TipoContratoEntity tipoContrato = cTipoContratoRepository.save(cTipoContrato); 
            return new ResponseEntity<>(tipoContrato, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoContratoEntity> updatingStatus(@PathVariable("id") String idTipoContrato, @RequestBody c_TipoContratoEntity cTipoContrato){
        Optional<c_TipoContratoEntity> tipoContratoData = cTipoContratoRepository.findById(idTipoContrato);
        if(tipoContratoData.isPresent()){
            c_TipoContratoEntity tipoContrato = tipoContratoData.get();
            tipoContrato.setStatus(cTipoContrato.getStatus());
            return new ResponseEntity<>(cTipoContratoRepository.save(tipoContrato),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}