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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_FormaPago;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_FormaPagoRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_FormaPagoService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/FormaPago")
public class c_FormaPagoController {
    @Autowired
    private c_FormaPagoRepository cFormaPagoRepository;

    @Autowired
    private c_FormaPagoService cFormaPagoService;

    /* @GetMapping
    public List<c_FormaPago> getAllData() {
        return (List<c_FormaPago>) formaPagoRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_FormaPago> data(@PathVariable("id") String id) {
        return cFormaPagoRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_FormaPago> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_FormaPago>) cFormaPagoService.getAllFormaPagoByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_FormaPago> createRegistro(@RequestBody c_FormaPago var) {
        try {
            c_FormaPago formaPago = cFormaPagoRepository.save(var);
            return new ResponseEntity<>(formaPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_FormaPago> updatingRegistro(@PathVariable("id") String idFormaPago, @RequestBody c_FormaPago cFormaPago){
        Optional<c_FormaPago> formaPagoData = cFormaPagoRepository.findById(idFormaPago);
        
        if(formaPagoData.isPresent()){
            c_FormaPago formaPago = formaPagoData.get();
            formaPago.setBancarizado(cFormaPago.getBancarizado());
            formaPago.setNombreBancoEmisorExtranjero(cFormaPago.getNombreBancoEmisorExtranjero());
            formaPago.setDescripcion(cFormaPago.getDescripcion());
            formaPago.setStatus(cFormaPago.getStatus());
            return new ResponseEntity<>(cFormaPagoRepository.save((formaPago)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_FormaPago> updatingStatus(@PathVariable("id") String idFormaPago, @RequestBody c_FormaPago cFormaPago){
        Optional<c_FormaPago> formaPagoData = cFormaPagoRepository.findById(idFormaPago);
        
        if(formaPagoData.isPresent()){
            c_FormaPago formaPago = formaPagoData.get();;
            formaPago.setStatus(cFormaPago.getStatus());
            return new ResponseEntity<>(cFormaPagoRepository.save(formaPago),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
