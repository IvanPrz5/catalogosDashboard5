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

import com.example.catalogosDashboard.Empleado.Entity.DeduccionEntity;
import com.example.catalogosDashboard.Empleado.Repository.DeduccionRepository;
import com.example.catalogosDashboard.Empleado.Service.DeduccionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Deduccion")
public class DeduccionController {
    
    @Autowired
    DeduccionRepository deduccionRepository;

    @Autowired
    DeduccionService deduccionService;

    @GetMapping("/sort/{status}")
    public List<DeduccionEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<DeduccionEntity>) deduccionService.getAllDeduccionesByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<DeduccionEntity> createRegistro(@RequestBody DeduccionEntity var) {
        try {
            DeduccionEntity deduccion = deduccionRepository.save(var);
            return new ResponseEntity<>(deduccion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DeduccionEntity> updatingRegistro(@PathVariable("id") Long idDeduccion, @RequestBody DeduccionEntity cDeduccion){
        Optional <DeduccionEntity> deduccionData = deduccionRepository.findById(idDeduccion);
        
        if(deduccionData.isPresent()){
            DeduccionEntity deduccion = deduccionRepository.save(cDeduccion);
            return new ResponseEntity<>(deduccion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<DeduccionEntity> updatingStatus(@PathVariable("id") Long idDeduccion, @RequestBody DeduccionEntity cDeduccion){
        Optional <DeduccionEntity> deduccionData = deduccionRepository.findById(idDeduccion);
        
        if(deduccionData.isPresent()){
            DeduccionEntity deduccion =  deduccionData.get();
            deduccion.setStatus(cDeduccion.getStatus());
            return new ResponseEntity<>(deduccionRepository.save(deduccion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
