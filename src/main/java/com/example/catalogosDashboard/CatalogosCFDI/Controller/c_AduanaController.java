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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Aduana;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_AduanaRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_AduanaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Aduana")
public class c_AduanaController {
    
    @Autowired
    private c_AduanaRepository cAduanaRepository;

    @Autowired
    private c_AduanaService cAduanaService;

    /* @GetMapping
    public List<c_Aduana> getAllData() {
        return (List<c_Aduana>) aduanaRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Aduana> data(@PathVariable("id") String id) {
        return cAduanaRepository.findById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_Aduana> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Aduana>) cAduanaService.getAllAduanaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Aduana> createRegistro(@RequestBody c_Aduana var) {
        try {
            c_Aduana aduana = cAduanaRepository.save(var);
            return new ResponseEntity<>(aduana, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Aduana> updatingRegistro(@PathVariable("id") String idAduana, @RequestBody c_Aduana cAduana){
        Optional<c_Aduana> aduanaData = cAduanaRepository.findById(idAduana);
        
        if(aduanaData.isPresent()){
            c_Aduana aduana =  aduanaData.get();
            aduana.setId(cAduana.getId());
            aduana.setDescripcion(cAduana.getDescripcion());
            aduana.setStatus(cAduana.getStatus());
            return new ResponseEntity<>(cAduanaRepository.save(aduana), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Aduana> updatingStatus(@PathVariable("id") String idAduana, @RequestBody c_Aduana cAduana){
        Optional<c_Aduana> aduanaData = cAduanaRepository.findById(idAduana);
        
        if(aduanaData.isPresent()){
            c_Aduana aduana =  aduanaData.get();
            aduana.setStatus(cAduana.getStatus());
            return new ResponseEntity<>(cAduanaRepository.save(aduana),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /* @DeleteMapping("/{caduana}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("caduana") String caduana) {
        try {
            aduanaRepository.deleteById(caduana);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */
}