package com.example.catalogosDashboard.Controller.CFDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.example.catalogosDashboard.Entity.CFDI.c_Impuesto;
import com.example.catalogosDashboard.Repository.CFDI.c_ImpuestoRepository;
import com.example.catalogosDashboard.Service.CFDI.c_ImpuestoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Impuesto")
public class c_ImpuestoController {

    @Autowired
    private c_ImpuestoRepository cImpuestoRepository;

    @Autowired
    private c_ImpuestoService cImpuestoService;

    /* @GetMapping
    public List<c_Impuesto> getAllData() {
        return (List<c_Impuesto>) cImpuestoRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Impuesto> data(@PathVariable("id") String id) {
        return cImpuestoRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Impuesto> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Impuesto>) cImpuestoService.getAllImpuestoByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Impuesto> createRegistro(@RequestBody c_Impuesto var) {
        try {
            c_Impuesto impuesto = cImpuestoRepository.save(var);
            return new ResponseEntity<>(impuesto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Impuesto> updatingRegistro(@PathVariable("id") String idImpuesto, @RequestBody c_Impuesto cImpuesto){
        Optional<c_Impuesto> impuestoData = cImpuestoRepository.findById(idImpuesto);
        
        if(impuestoData.isPresent()){
            c_Impuesto impuesto =  impuestoData.get();
            impuesto.setDescripcion(cImpuesto.getDescripcion());
            impuesto.setRetencion(cImpuesto.getRetencion());
            impuesto.setTraslado(cImpuesto.getTraslado());
            impuesto.setLocalFederal(cImpuesto.getLocalFederal());
            impuesto.setStatus(cImpuesto.getStatus());
            return new ResponseEntity<>(cImpuestoRepository.save(impuesto), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Impuesto> updatingStatus(@PathVariable("id") String idImpuesto, @RequestBody c_Impuesto cImpuesto){
        Optional<c_Impuesto> impuestoData = cImpuestoRepository.findById(idImpuesto);
        
        if(impuestoData.isPresent()){
            c_Impuesto impuesto =  impuestoData.get();
            impuesto.setStatus(cImpuesto.getStatus());
            return new ResponseEntity<>(cImpuestoRepository.save(impuesto),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
