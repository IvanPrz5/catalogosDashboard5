package com.example.catalogosDashboard.CatalogosNomina.Controller;

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

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoPercepcionEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoPercepcionRepository;
import com.example.catalogosDashboard.CatalogosNomina.Service.c_TipoPercepcionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoPercepcion")
public class c_TipoPercepcionController {

    @Autowired
    private c_TipoPercepcionService cTipoPercepcionService;

    @Autowired
    private c_TipoPercepcionRepository cTipoPercepcionRepository;

    /* @GetMapping
    public List<c_TipoPercepcionEntity> getAllData(){
        return (List<c_TipoPercepcionEntity>) cTipoPercepcionService.getAllTipoPercepcion();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoPercepcionEntity> getDataByIdTipoPercepcion(@PathVariable("id") String id) {
        return cTipoPercepcionService.getTipoPercepcionById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoPercepcionEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoPercepcionEntity>) cTipoPercepcionService.getAllTipoPercepcionByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoPercepcionEntity> createRegistro(@RequestBody c_TipoPercepcionEntity var) {
        try {
            c_TipoPercepcionEntity tipoPercepcion = cTipoPercepcionRepository.save(var);
            return new ResponseEntity<>(tipoPercepcion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<c_TipoPercepcionEntity> updatingRegistro(@PathVariable("id") String idTipoPercepcion, @RequestBody c_TipoPercepcionEntity cTipoPercepcion){
        Optional<c_TipoPercepcionEntity> tipoPercepcionData = cTipoPercepcionRepository.findById(idTipoPercepcion);
        
        if(tipoPercepcionData.isPresent()){
            c_TipoPercepcionEntity tipoPercepcion = cTipoPercepcionRepository.save(cTipoPercepcion);
            return new ResponseEntity<>(tipoPercepcion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoPercepcionEntity> updatingStatus(@PathVariable("id") String idTipoPercepcion, @RequestBody c_TipoPercepcionEntity cTipoPercepcion){
        Optional<c_TipoPercepcionEntity> tipoPercepcionData = cTipoPercepcionRepository.findById(idTipoPercepcion);
        
        if(tipoPercepcionData.isPresent()){
            c_TipoPercepcionEntity tipoPercepcion =  tipoPercepcionData.get();
            tipoPercepcion.setStatus(cTipoPercepcion.getStatus());
            return new ResponseEntity<>(cTipoPercepcionRepository.save(tipoPercepcion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}