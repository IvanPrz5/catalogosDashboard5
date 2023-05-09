package com.example.catalogosDashboard.Controller.Nomina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.Nomina.c_OrigenRecursoEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_OrigenRecursoRepository;
import com.example.catalogosDashboard.Service.Nomina.c_OrigenRecursoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/OrigenRecurso")
public class c_OrigenRecursoController {
    
    @Autowired
    private c_OrigenRecursoService cOrigenRecursoService;

    @Autowired
    private c_OrigenRecursoRepository cOrigenRecursoRepository;

    /* @GetMapping
    public List<c_OrigenRecursoEntity> getAllData(){
        return (List<c_OrigenRecursoEntity>) cOrigenRecursoService.getAllOrigenRecurso();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_OrigenRecursoEntity> getDataByIdOrigenRecurso(@PathVariable("id") Integer id) {
        return cOrigenRecursoService.getOrigenRecursoById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_OrigenRecursoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_OrigenRecursoEntity>) cOrigenRecursoService.getAllOrigenRecursoByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_OrigenRecursoEntity> createRegistro(@RequestBody c_OrigenRecursoEntity var) {
        try {
            c_OrigenRecursoEntity origenRecurso = cOrigenRecursoRepository.save(var);
            return new ResponseEntity<>(origenRecurso, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_OrigenRecursoEntity> updatingRegistro(@PathVariable("id") Integer idOrigenRecurso, @RequestBody c_OrigenRecursoEntity cOrigenRecurso){
        Optional<c_OrigenRecursoEntity> origenRecursoData = cOrigenRecursoRepository.findById(idOrigenRecurso);
        
        if(origenRecursoData.isPresent()){
            c_OrigenRecursoEntity origenRecurso = cOrigenRecursoRepository.save(cOrigenRecurso);
            return new ResponseEntity<>(origenRecurso, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_OrigenRecursoEntity> updatingStatus(@PathVariable("id") Integer idOrigenRecurso, @RequestBody c_OrigenRecursoEntity cOrigenRecurso){
        Optional<c_OrigenRecursoEntity> origenRecursoData = cOrigenRecursoRepository.findById(idOrigenRecurso);
        
        if(origenRecursoData.isPresent()){
            c_OrigenRecursoEntity origenRecurso =  origenRecursoData.get();
            origenRecurso.setStatus(cOrigenRecurso.getStatus());
            return new ResponseEntity<>(cOrigenRecursoRepository.save(origenRecurso),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}