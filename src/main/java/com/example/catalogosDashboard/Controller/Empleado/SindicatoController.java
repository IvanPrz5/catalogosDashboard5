package com.example.catalogosDashboard.Controller.Empleado;

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

import com.example.catalogosDashboard.Entity.Empleado.SindicatoEntity;
import com.example.catalogosDashboard.Repository.Empleado.SindicatoRepository;
import com.example.catalogosDashboard.Service.Empleado.SindicatoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Sindicato")
public class SindicatoController {
    
    @Autowired
    SindicatoRepository sindicatoRepository;

    @Autowired
    SindicatoService sindicatoService;

    @GetMapping("/sort/{status}")
    public List<SindicatoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<SindicatoEntity>) sindicatoService.getAllSindicatoByStatus(status, sort);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<SindicatoEntity> createRegistro(@RequestBody SindicatoEntity var) {
        try {
            SindicatoEntity sindicato = sindicatoRepository.save(var);
            return new ResponseEntity<>(sindicato, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<SindicatoEntity> updatingRegistro(@PathVariable("id") Long idSindicato, @RequestBody SindicatoEntity cSindicato){
        Optional <SindicatoEntity> sindicatoData = sindicatoRepository.findById(idSindicato);
        
        if(sindicatoData.isPresent()){
            SindicatoEntity sindicato = sindicatoRepository.save(cSindicato);
            return new ResponseEntity<>(sindicato, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<SindicatoEntity> updatingStatus(@PathVariable("id") Long idSindicato, @RequestBody SindicatoEntity cSindicato){
        Optional <SindicatoEntity> sindicatoData = sindicatoRepository.findById(idSindicato);

        if(sindicatoData.isPresent()){
            SindicatoEntity sindicato =  sindicatoData.get();
            sindicato.setStatus(cSindicato.getStatus());
            return new ResponseEntity<>(sindicatoRepository.save(sindicato), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
