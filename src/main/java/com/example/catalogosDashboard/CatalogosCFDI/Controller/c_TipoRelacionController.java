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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TipoRelacion;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_TipoRelacionRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_TipoRelacionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoRelacion")
public class c_TipoRelacionController {
    
    @Autowired
    private c_TipoRelacionRepository tipoRelacionRepository;

    @Autowired
    private c_TipoRelacionService tipoRelacionService;

    /* @GetMapping
    public List<c_TipoRelacion> getAllData() {
        return (List<c_TipoRelacion>) tiporelacionRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoRelacion> data(@PathVariable("id") String id) {
        return tipoRelacionRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_TipoRelacion> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoRelacion>) tipoRelacionService.getAllTipoRelacionByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoRelacion> createRegistro(@RequestBody c_TipoRelacion var) {
        try {
            c_TipoRelacion tipoRelacion = tipoRelacionRepository.save(var);
            return new ResponseEntity<>(tipoRelacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoRelacion> updatingRegistro(@PathVariable("id") String idTipoRel, @RequestBody c_TipoRelacion cTipoRel){
        Optional<c_TipoRelacion> tipoRelData = tipoRelacionRepository.findById(idTipoRel);
        
        if(tipoRelData.isPresent()){
            c_TipoRelacion tipoRelacion = tipoRelData.get();
            tipoRelacion.setDescripcion(cTipoRel.getDescripcion());
            tipoRelacion.setStatus(cTipoRel.getStatus());
            return new ResponseEntity<>(tipoRelacionRepository.save((tipoRelacion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoRelacion> updatingStatus(@PathVariable("id") String idTipoRel, @RequestBody c_TipoRelacion cTipoRel){
        Optional<c_TipoRelacion> tipoRelData = tipoRelacionRepository.findById(idTipoRel);
        
        if(tipoRelData.isPresent()){
            c_TipoRelacion tipoRelacion = tipoRelData.get();
            tipoRelacion.setStatus(cTipoRel.getStatus());
            return new ResponseEntity<>(tipoRelacionRepository.save(tipoRelacion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
