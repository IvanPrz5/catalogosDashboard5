package com.example.catalogosDashboard.Controller.Nomina;

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

import com.example.catalogosDashboard.Entity.Nomina.c_TipoIncapacidadEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_TipoIncapacidadRepository;
import com.example.catalogosDashboard.Service.Nomina.c_TipoIncapacidadService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoIncapacidad")
public class c_TipoIncapacidadController {

    @Autowired
    private c_TipoIncapacidadService cTipoIncapacidadService;

    @Autowired
    private c_TipoIncapacidadRepository cTipoIncapacidadRepository;

    /* @GetMapping
    public List<c_TipoIncapacidadEntity> getAllData(){
        return (List<c_TipoIncapacidadEntity>) cTipoIncapacidadService.getAllTipoIncapacidad();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoIncapacidadEntity> getDataByIdTipoIncapacidad(@PathVariable("id") String id) {
        return cTipoIncapacidadService.getTipoIncapacidadById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoIncapacidadEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoIncapacidadEntity>) cTipoIncapacidadService.getAllTipoIncapacidadByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoIncapacidadEntity> createRegistro(@RequestBody c_TipoIncapacidadEntity var) {
        try {
            c_TipoIncapacidadEntity tipoIncapacidad = cTipoIncapacidadRepository.save(var);
            return new ResponseEntity<>(tipoIncapacidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoIncapacidadEntity> updatingRegistro(@PathVariable("id") String idTipoIncapacidad, @RequestBody c_TipoIncapacidadEntity cTipoIncapacidad){
        Optional<c_TipoIncapacidadEntity> tipoIncapacidadData = cTipoIncapacidadRepository.findById(idTipoIncapacidad);
        
        if(tipoIncapacidadData.isPresent()){
            c_TipoIncapacidadEntity tipoIncapacidad = cTipoIncapacidadRepository.save(cTipoIncapacidad);
            return new ResponseEntity<>(tipoIncapacidad, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoIncapacidadEntity> updatingStatus(@PathVariable("id") String idTipoIncapacidad, @RequestBody c_TipoIncapacidadEntity cTipoIncapacidad){
        Optional<c_TipoIncapacidadEntity> tipoIncapacidadData = cTipoIncapacidadRepository.findById(idTipoIncapacidad);
        
        if(tipoIncapacidadData.isPresent()){
            c_TipoIncapacidadEntity tipoIncapacidad =  tipoIncapacidadData.get();
            tipoIncapacidad.setStatus(cTipoIncapacidad.getStatus());
            return new ResponseEntity<>(cTipoIncapacidadRepository.save(tipoIncapacidad),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}