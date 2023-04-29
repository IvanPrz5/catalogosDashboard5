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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TipoComp;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_TipoCompRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_TipoCompService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoComprobante")
public class c_TipoComController {
    @Autowired
    private c_TipoCompRepository tipoComRepository;

    @Autowired
    private c_TipoCompService tipoComService;

    /* @GetMapping
    public List<c_TipoComp> getAllData() {
        return (List<c_TipoComp>) tipocomRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoComp> data(@PathVariable("id") String id) {
        return tipoComRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_TipoComp> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoComp>) tipoComService.getAllTipoCompByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoComp> createRegistro(@RequestBody c_TipoComp var) {
        try {
            c_TipoComp tipoDeComprobante = tipoComRepository.save(var);
            return new ResponseEntity<>(tipoDeComprobante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoComp> updatingRegistro(@PathVariable("id") String idTipoCom, @RequestBody c_TipoComp cTipoCom){
        Optional<c_TipoComp> tipocomData = tipoComRepository.findById(idTipoCom);
        
        if(tipocomData.isPresent()){
            c_TipoComp tipoDeComprobante = tipocomData.get();
            tipoDeComprobante.setDescripcion(cTipoCom.getDescripcion());
            tipoDeComprobante.setStatus(cTipoCom.getStatus());
            return new ResponseEntity<>(tipoComRepository.save((tipoDeComprobante)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoComp> updatingStatus(@PathVariable("id") String idTipoCom, @RequestBody c_TipoComp cTipoCom){
        Optional<c_TipoComp> tipocomData = tipoComRepository.findById(idTipoCom);
        
        if(tipocomData.isPresent()){
            c_TipoComp tipoDeComprobante = tipocomData.get();
            tipoDeComprobante.setStatus(cTipoCom.getStatus());
            return new ResponseEntity<>(tipoComRepository.save(tipoDeComprobante),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
