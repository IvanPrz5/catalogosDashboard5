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

import com.example.catalogosDashboard.Entity.CFDI.c_CodigoPostal;
import com.example.catalogosDashboard.Repository.CFDI.c_CodigoPostalRepository;
import com.example.catalogosDashboard.Service.CFDI.c_CodigoPostalService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/CodigoPostal")
public class c_CodigoPostalController {
    @Autowired
    private c_CodigoPostalRepository cCodigoPostalRepository;

    @Autowired
    private c_CodigoPostalService cCodigoPostalService;

    @GetMapping("/byId/{id}/{status}")
    public Optional<c_CodigoPostal> byIdAndStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status, Sort sort){
        return (Optional<c_CodigoPostal>) cCodigoPostalService.getByIdAndStatus(id, status, sort);
    }

    @Transactional
    @GetMapping("/combo/sort/{status}/{id}")
    public List<c_CodigoPostal> byIdEstadoAndStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status, Sort sort ){
        return (List<c_CodigoPostal>) cCodigoPostalService.getByIdEstadoAndStatus(id, status, sort);
    }

    @GetMapping("/sort/{status}")
    public List<c_CodigoPostal> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_CodigoPostal>) cCodigoPostalService.getAllCodigoPostalByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_CodigoPostal> createRegistro(@RequestBody c_CodigoPostal var) {
        try {
            c_CodigoPostal codigoPostal = cCodigoPostalRepository.save(var);
            return new ResponseEntity<>(codigoPostal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* @PutMapping("/editar/{id}")
    public ResponseEntity<c_CodigoPostal> updatingRegistro(@PathVariable("id") String idCodigoPostal, @RequestBody c_CodigoPostal cCodigoPostal){
        Optional<c_CodigoPostal> codigoPostalData = cCodigoPostalRepository.findById(idCodigoPostal);
        
        if(codigoPostalData.isPresent()){
            c_CodigoPostal codigoPostal =  codigoPostalData.get();
            codigoPostal.setDescripcion(cCodigoPostal.getDescripcion());
            codigoPostal.setStatus(cCodigoPostal.getStatus());
            return new ResponseEntity<>(cCodigoPostalRepository.save(codigoPostal), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_CodigoPostal> updatingStatus(@PathVariable("id") String idCodigoPostal, @RequestBody c_CodigoPostal cCodigoPostal){
        Optional<c_CodigoPostal> codigoPostalData = cCodigoPostalRepository.findById(idCodigoPostal);
        
        if(codigoPostalData.isPresent()){
            c_CodigoPostal codigoPostal =  codigoPostalData.get();
            codigoPostal.setStatus(cCodigoPostal.getStatus());
            return new ResponseEntity<>(cCodigoPostalRepository.save(codigoPostal),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
