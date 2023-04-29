package com.example.catalogosDashboard.CatalogosCFDI.Controller;

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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_MetodoPago;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_MetodoPagoRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_MetodoPagoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/MetodoPago")
public class c_MetodoPagoController {
    
    @Autowired
    private c_MetodoPagoRepository cMetodoPagoRepository;

    @Autowired
    private c_MetodoPagoService cMetodoPagoService;

    /* @GetMapping
    public List<c_MetodoPago> getAllData() {
        return (List<c_MetodoPago>) cMetodopagoRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_MetodoPago> data(@PathVariable("id") String id) {
        return cMetodoPagoRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_MetodoPago> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_MetodoPago>) cMetodoPagoService.getAllMetodoPagoByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_MetodoPago> createRegistro(@RequestBody c_MetodoPago var) {
        try {
            c_MetodoPago metodoPago = cMetodoPagoRepository.save(var);
            return new ResponseEntity<>(metodoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<c_MetodoPago> updatingRegistro(@PathVariable("id") String idMetodoPago, @RequestBody c_MetodoPago cMetodoPago){
        Optional<c_MetodoPago> metodopagoData = cMetodoPagoRepository.findById(idMetodoPago);
        
        if(metodopagoData.isPresent()){
            c_MetodoPago metodoPago = metodopagoData.get();
            metodoPago.setDescripcion(cMetodoPago.getDescripcion());
            metodoPago.setStatus(cMetodoPago.getStatus());
            return new ResponseEntity<>(cMetodoPagoRepository.save((metodoPago)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_MetodoPago> updatingStatus(@PathVariable("id") String idMetodoPago, @RequestBody c_MetodoPago cMetodoPago){
        Optional<c_MetodoPago> metodopagoData = cMetodoPagoRepository.findById(idMetodoPago);
        
        if(metodopagoData.isPresent()){
            c_MetodoPago metodoPago = metodopagoData.get();
            metodoPago.setStatus(cMetodoPago.getStatus());
            return new ResponseEntity<>(cMetodoPagoRepository.save(metodoPago),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
