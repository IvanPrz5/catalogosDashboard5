package com.example.catalogosDashboard.Empleado.Controller;

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

import com.example.catalogosDashboard.Empleado.Entity.PercepcionesEntity;
import com.example.catalogosDashboard.Empleado.Repository.PercepcionesRepository;
import com.example.catalogosDashboard.Empleado.Service.PercepcionesService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Percepciones")
public class PercepcionesController {

    @Autowired
    PercepcionesRepository percepcionesRepository;

    @Autowired
    PercepcionesService percepcionesService;

    @GetMapping("/sort/{status}")
    public List<PercepcionesEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<PercepcionesEntity>) percepcionesService.getAllPercepcionesByStatus(status, sort);
    }    

    @PostMapping("/agregar")
    public ResponseEntity<PercepcionesEntity> createRegistro(@RequestBody PercepcionesEntity var) {
        try {
            PercepcionesEntity percepciones = percepcionesRepository.save(var);
            return new ResponseEntity<>(percepciones, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PercepcionesEntity> updatingRegistro(@PathVariable("id") Long idPercepcion, @RequestBody PercepcionesEntity cPercepcion){
        Optional <PercepcionesEntity> percepcionData = percepcionesRepository.findById(idPercepcion);
        
        if(percepcionData.isPresent()){
            PercepcionesEntity percepcion = percepcionesRepository.save(cPercepcion);
            return new ResponseEntity<>(percepcion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<PercepcionesEntity> updatingStatus(@PathVariable("id") Long idPercepcion, @RequestBody PercepcionesEntity cPercepcion){
        Optional <PercepcionesEntity> percepcionData = percepcionesRepository.findById(idPercepcion);

        if(percepcionData.isPresent()){
            PercepcionesEntity percepcion =  percepcionData.get();
            percepcion.setStatus(cPercepcion.getStatus());
            return new ResponseEntity<>(percepcionesRepository.save(percepcion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
