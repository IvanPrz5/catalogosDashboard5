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

import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Repository.CFDI.c_EstadoRepository;
import com.example.catalogosDashboard.Service.CFDI.c_EstadoService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Estado")
public class c_EstadoController {

    @Autowired
    private c_EstadoRepository cEstadoRepository;

    @Autowired
    private c_EstadoService cEstadoService;

    /* @GetMapping(value = "/{id}")
    public Optional<c_Estado> data(@PathVariable("id") String id) {
        return cEstadoRepository.findById(id);
    } */

    @GetMapping("/sort/{status}")
    public List<c_Estado> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Estado>) cEstadoService.getAllEstadoByStatus(status, sort);
    }

    @Transactional
    @GetMapping("/sort/{id}/{status}")
    public List<c_Estado> byIdPaisAndStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Estado>) cEstadoService.getByIdPaisAndStatus(id, status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Estado> createRegistro(@RequestBody c_Estado var) {
        try {
            c_Estado estado = cEstadoRepository.save(var);
            return new ResponseEntity<>(estado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Estado> updatingRegistro(@PathVariable("id") String idEstado, @RequestBody c_Estado cEstado){
        Optional<c_Estado> estadoData = cEstadoRepository.findById(idEstado);
        
        if(estadoData.isPresent()){
            c_Estado estado =  estadoData.get();
            estado.setNombreEstado(cEstado.getNombreEstado());
            estado.setStatus(cEstado.getStatus());
            return new ResponseEntity<>(cEstadoRepository.save(estado), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Estado> updatingStatus(@PathVariable("id") String idEstado, @RequestBody c_Estado cEstado){
        Optional<c_Estado> estadoData = cEstadoRepository.findById(idEstado);
        
        if(estadoData.isPresent()){
            c_Estado estado =  estadoData.get();
            estado.setStatus(cEstado.getStatus());
            return new ResponseEntity<>(cEstadoRepository.save(estado),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
