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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_ObjetoImp;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_ObjetoImpRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_ObjetoImpService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/ObjetoImp")
public class c_ObjetoImpController {
    @Autowired
    private c_ObjetoImpRepository cObjetoImpRepository;

    @Autowired
    private c_ObjetoImpService cObjetoImpService;

    /* @GetMapping
    public List<c_ObjetoImp> getAllData() {
        return (List<c_ObjetoImp>) cObjetoimpRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_ObjetoImp> data(@PathVariable("id") String id) {
        return cObjetoImpRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_ObjetoImp> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_ObjetoImp>) cObjetoImpService.getAllObjetoImpByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_ObjetoImp> createRegistro(@RequestBody c_ObjetoImp var) {
        try {
            c_ObjetoImp objetoimp = cObjetoImpRepository.save(var);
            return new ResponseEntity<>(objetoimp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_ObjetoImp> updatingRegistro(@PathVariable("id") String idObjetoImp, @RequestBody c_ObjetoImp cObjetoImp){
        Optional<c_ObjetoImp> objetoImpData = cObjetoImpRepository.findById(idObjetoImp);
        
        if(objetoImpData.isPresent()){
            c_ObjetoImp objetoImp =  objetoImpData.get();
            objetoImp.setDescripcion(cObjetoImp.getDescripcion());
            objetoImp.setStatus(cObjetoImp.getStatus());
            return new ResponseEntity<>(cObjetoImpRepository.save(objetoImp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_ObjetoImp> updatingStatus(@PathVariable("id") String idObjetoImp, @RequestBody c_ObjetoImp cObjetoImp){
        Optional<c_ObjetoImp> objetoImpData = cObjetoImpRepository.findById(idObjetoImp);
        
        if(objetoImpData.isPresent()){
            c_ObjetoImp objetoImp =  objetoImpData.get();
            objetoImp.setStatus(cObjetoImp.getStatus());
            return new ResponseEntity<>(cObjetoImpRepository.save(objetoImp),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
