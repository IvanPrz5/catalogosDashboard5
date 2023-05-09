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

import com.example.catalogosDashboard.Entity.CFDI.c_PatenteAduanal;
import com.example.catalogosDashboard.Repository.CFDI.c_PatenteAduanalRepository;
import com.example.catalogosDashboard.Service.CFDI.c_PatenteAduanalService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/PatenteAduanal")
public class c_PatenteAduanalController {
    @Autowired
    private c_PatenteAduanalRepository cPatenteAduanalRepository;

    @Autowired
    private c_PatenteAduanalService cPatenteAduanalService;

    /* @GetMapping
    public List<c_PatenteAduanal> getAllData() {
        return (List<c_PatenteAduanal>) patenteaduanalRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_PatenteAduanal> data(@PathVariable("id") String id) {
        return cPatenteAduanalRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_PatenteAduanal> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_PatenteAduanal>) cPatenteAduanalService.getAllPatenteAduanalByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_PatenteAduanal> createRegistro(@RequestBody c_PatenteAduanal var) {
        try {
            c_PatenteAduanal patenteAduanal = cPatenteAduanalRepository.save(var);
            return new ResponseEntity<>(patenteAduanal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /* @PutMapping("/editar/{id}")
    public ResponseEntity<c_PatenteAduanal> updatingRegistro(@PathVariable("id") String idPatenteAduanal, @RequestBody c_PatenteAduanal cPatenteAduanal){
        Optional<c_PatenteAduanal> patenteAduanalData = cPatenteAduanalRepository.findById(idPatenteAduanal);
        
        if(patenteAduanalData.isPresent()){
            c_PatenteAduanal patenteAduanal = patenteAduanalData.get();
            patenteAduanal.setStatus(cPatenteAduanal.getStatus());
            return new ResponseEntity<>(cPatenteAduanalRepository.save(patenteAduanal), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_PatenteAduanal> updatingRegistro(@PathVariable("id") String idPatenteAduanal, @RequestBody c_PatenteAduanal cPatenteAduanal){
        Optional<c_PatenteAduanal> patenteAduanalData = cPatenteAduanalRepository.findById(idPatenteAduanal);
        
        if(patenteAduanalData.isPresent()){
            c_PatenteAduanal patenteAduanal = patenteAduanalData.get();
            patenteAduanal.setStatus(cPatenteAduanal.getStatus());
            return new ResponseEntity<>(cPatenteAduanalRepository.save(patenteAduanal),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
