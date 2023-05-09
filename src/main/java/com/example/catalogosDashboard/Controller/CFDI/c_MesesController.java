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

import com.example.catalogosDashboard.Entity.CFDI.c_Meses;
import com.example.catalogosDashboard.Repository.CFDI.c_MesesRepository;
import com.example.catalogosDashboard.Service.CFDI.c_MesesService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Meses")
public class c_MesesController {
    
    @Autowired
    private c_MesesRepository cMesesRepository;

    @Autowired 
    private c_MesesService cMesesService;

    /* @GetMapping
    public List<c_Meses> getAllData() {
        return (List<c_Meses>) cMesesRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Meses> data(@PathVariable("id") String id) {
        return cMesesRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Meses> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Meses>) cMesesService.getAllMesesByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Meses> createRegistro(@RequestBody c_Meses var) {
        try {
            c_Meses meses = cMesesRepository.save(var);
            return new ResponseEntity<>(meses, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{cmeses}")
    public ResponseEntity<c_Meses> updatingRegistro(@PathVariable("cmeses") String idMeses, @RequestBody c_Meses cMeses){
        Optional<c_Meses> mesesData = cMesesRepository.findById(idMeses);
        
        if(mesesData.isPresent()){
            c_Meses meses = mesesData.get();
            meses.setDescripcion(cMeses.getDescripcion());
            meses.setStatus(cMeses.getStatus());
            return new ResponseEntity<>(cMesesRepository.save((meses)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Meses> updatingStatis(@PathVariable("id") String idMeses, @RequestBody c_Meses cMeses){
        Optional<c_Meses> mesesData = cMesesRepository.findById(idMeses);
        
        if(mesesData.isPresent()){
            c_Meses meses = mesesData.get();
            meses.setStatus(cMeses.getStatus());
            return new ResponseEntity<>(cMesesRepository.save(meses),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
