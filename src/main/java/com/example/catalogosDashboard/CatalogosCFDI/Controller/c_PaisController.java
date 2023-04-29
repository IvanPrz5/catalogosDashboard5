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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Pais;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_PaisRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_PaisService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Pais")
public class c_PaisController {
    
    @Autowired
    private c_PaisRepository cPaisRepository;

    @Autowired
    private c_PaisService cPaisService;

    /* @GetMapping
    public List<c_Pais> getAllData() {
        return (List<c_Pais>) cPaisRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Pais> data(@PathVariable("id") String id) {
        return cPaisRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Pais> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Pais>) cPaisService.getAllPaisByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Pais> createRegistro(@RequestBody c_Pais var) {
        try {
            c_Pais pais = cPaisRepository.save(var);
            return new ResponseEntity<>(pais, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Pais> updatingRegistro(@PathVariable("id") String idPais, @RequestBody c_Pais cPais){
        Optional<c_Pais> paisData = cPaisRepository.findById(idPais);
        
        if(paisData.isPresent()){
            c_Pais pais =  paisData.get();
            pais.setDescripcion(cPais.getDescripcion());
            pais.setStatus(cPais.getStatus());
            return new ResponseEntity<>(cPaisRepository.save(pais), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Pais> updatingStatus(@PathVariable("id") String idPais, @RequestBody c_Pais cPais){
        Optional<c_Pais> paisData = cPaisRepository.findById(idPais);
        
        if(paisData.isPresent()){
            c_Pais pais =  paisData.get();
            pais.setStatus(cPais.getStatus());
            return new ResponseEntity<>(cPaisRepository.save(pais),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
