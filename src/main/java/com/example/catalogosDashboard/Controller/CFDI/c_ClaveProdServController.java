package com.example.catalogosDashboard.Controller.CFDI;

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

import com.example.catalogosDashboard.Entity.CFDI.c_ClaveProdServ;
import com.example.catalogosDashboard.Repository.CFDI.c_ClaveProdServRepository;
import com.example.catalogosDashboard.Service.CFDI.c_ClaveProdServServicio;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/ClaveProdServ")
public class c_ClaveProdServController {

    @Autowired
    private c_ClaveProdServRepository cClaveProdServRepository;

    @Autowired 
    private c_ClaveProdServServicio cClaveProdServService;

    /* @GetMapping
    public List<c_ClaveProdServ> getAllData() {
        return (List<c_ClaveProdServ>) cClaveProdServRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_ClaveProdServ> data(@PathVariable("id") String id) {
        return cClaveProdServRepository.findById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_ClaveProdServ> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_ClaveProdServ>) cClaveProdServService.getAllClaveProdServByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_ClaveProdServ> createRegistro(@RequestBody c_ClaveProdServ var) {
        try {
            c_ClaveProdServ claveProdServ = cClaveProdServRepository.save(var);
            return new ResponseEntity<>(claveProdServ, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_ClaveProdServ> updatingRegistro(@PathVariable("id") String idClaveProdServ, @RequestBody c_ClaveProdServ cClaveProdServ){
        Optional<c_ClaveProdServ> claveProdServData = cClaveProdServRepository.findById(idClaveProdServ);
        
        if(claveProdServData.isPresent()){
            c_ClaveProdServ claveProdServ =  claveProdServData.get();
            claveProdServ.setDescripcion(cClaveProdServ.getDescripcion());
            claveProdServ.setPalabrasSimilares(cClaveProdServ.getPalabrasSimilares());
            claveProdServ.setStatus(cClaveProdServ.getStatus());
            return new ResponseEntity<>(cClaveProdServRepository.save(claveProdServ), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_ClaveProdServ> updatingStatus(@PathVariable("id") String idClaveProdServ, @RequestBody c_ClaveProdServ cClaveProdServ){
        Optional<c_ClaveProdServ> claveProdServData = cClaveProdServRepository.findById(idClaveProdServ);
        
        if(claveProdServData.isPresent()){
            c_ClaveProdServ claveProdServ =  claveProdServData.get();
            claveProdServ.setStatus(cClaveProdServ.getStatus());
            return new ResponseEntity<>(cClaveProdServRepository.save(claveProdServ),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
