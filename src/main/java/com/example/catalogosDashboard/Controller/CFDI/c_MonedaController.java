package com.example.catalogosDashboard.Controller.CFDI;

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

import com.example.catalogosDashboard.Entity.CFDI.c_Moneda;
import com.example.catalogosDashboard.Repository.CFDI.c_MonedaRepository;
import com.example.catalogosDashboard.Service.CFDI.c_MonedaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Moneda")
public class c_MonedaController {
    @Autowired
    private c_MonedaRepository cMonedaRepository;

    @Autowired
    private c_MonedaService cMonedaService;

    /* @GetMapping
    public List<c_Moneda> getAllData() {
        return (List<c_Moneda>) cMonedaRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Moneda> data(@PathVariable("id") String id) {
        return cMonedaRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Moneda> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Moneda>) cMonedaService.getAllMonedaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Moneda> createRegistro(@RequestBody c_Moneda var) {
        try {
            c_Moneda moneda = cMonedaRepository.save(var);
            return new ResponseEntity<>(moneda, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Moneda> updatingRegistro(@PathVariable("id") String idMoneda, @RequestBody c_Moneda cMoneda){
        Optional<c_Moneda> monedaData = cMonedaRepository.findById(idMoneda);
        
        if(monedaData.isPresent()){
            c_Moneda moneda = monedaData.get();
            moneda.setDescripcion(cMoneda.getDescripcion());
            moneda.setStatus(cMoneda.getStatus());
            return new ResponseEntity<>(cMonedaRepository.save((moneda)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Moneda> updatingStatus(@PathVariable("id") String idMoneda, @RequestBody c_Moneda cMoneda){
        Optional<c_Moneda> monedaData = cMonedaRepository.findById(idMoneda);
        
        if(monedaData.isPresent()){
            c_Moneda moneda = monedaData.get();
            moneda.setStatus(cMoneda.getStatus());
            return new ResponseEntity<>(cMonedaRepository.save(moneda),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
