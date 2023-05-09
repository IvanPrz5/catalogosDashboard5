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

import com.example.catalogosDashboard.Entity.CFDI.c_RegimenFiscal;
import com.example.catalogosDashboard.Repository.CFDI.c_RegimenFiscalRepository;
import com.example.catalogosDashboard.Service.CFDI.c_RegimenFiscalService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/RegimenFiscal")
public class c_RegimenFiscalController {
    
    @Autowired
    private c_RegimenFiscalRepository regimenFiscalRepository;

    @Autowired
    private c_RegimenFiscalService regimenFiscalService;

    /* @GetMapping
    public List<c_RegimenFiscal> getAllData() {
        return (List<c_RegimenFiscal>) regimenfiscalRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_RegimenFiscal> data(@PathVariable("id") String id) {
        return regimenFiscalRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_RegimenFiscal> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_RegimenFiscal>) regimenFiscalService.getAllRegimenFiscalByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_RegimenFiscal> createRegistro(@RequestBody c_RegimenFiscal var) {
        try {
            c_RegimenFiscal regimenFiscal = regimenFiscalRepository.save(var);
            return new ResponseEntity<>(regimenFiscal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_RegimenFiscal> updatingRegistro(@PathVariable("id") String idRegimenF, @RequestBody c_RegimenFiscal cRegimenF){
        Optional<c_RegimenFiscal> regimenFData = regimenFiscalRepository.findById(idRegimenF);
        
        if(regimenFData.isPresent()){
            c_RegimenFiscal regimenFiscal = regimenFData.get();
            regimenFiscal.setDescripcion(cRegimenF.getDescripcion());
            regimenFiscal.setFisica(cRegimenF.getFisica());
            regimenFiscal.setMoral(cRegimenF.getMoral());
            regimenFiscal.setStatus(cRegimenF.getStatus());
            return new ResponseEntity<>(regimenFiscalRepository.save((regimenFiscal)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_RegimenFiscal> updatingStatus(@PathVariable("id") String idRegimenFiscal, @RequestBody c_RegimenFiscal cRegimenFiscal){
        Optional<c_RegimenFiscal> regimenFData = regimenFiscalRepository.findById(idRegimenFiscal);
        
        if(regimenFData.isPresent()){
            c_RegimenFiscal regimenFiscal = regimenFData.get();
            regimenFiscal.setStatus(cRegimenFiscal.getStatus());
            return new ResponseEntity<>(regimenFiscalRepository.save(regimenFiscal),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
