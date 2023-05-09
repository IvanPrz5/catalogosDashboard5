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

import com.example.catalogosDashboard.Entity.Nomina.c_TipoJornadaEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_TipoJornadaRepository;
import com.example.catalogosDashboard.Service.Nomina.c_TipoJornadaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoJornada")
public class c_TipoJornadaController {

    @Autowired
    private c_TipoJornadaService cTipoJornadaService;

    @Autowired
    private c_TipoJornadaRepository cTipoJornadaRepository;

    /* @GetMapping
    public List<c_TipoJornadaEntity> getAllData(){
        return (List<c_TipoJornadaEntity>) cTipoJornadaService.getAllTipoJornada();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoJornadaEntity> getDataByIdTipoJornada(@PathVariable("id") String id) {
        return cTipoJornadaService.getTipoJornadaById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoJornadaEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoJornadaEntity>) cTipoJornadaService.getAllTipoJornadaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoJornadaEntity> createRegistro(@RequestBody c_TipoJornadaEntity var) {
        try {
            c_TipoJornadaEntity tipoJornada = cTipoJornadaRepository.save(var);
            return new ResponseEntity<>(tipoJornada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoJornadaEntity> updatingRegistro(@PathVariable("id") String idTipoJornada, @RequestBody c_TipoJornadaEntity cTipoJornada){
        Optional<c_TipoJornadaEntity> tipoJornadaData = cTipoJornadaRepository.findById(idTipoJornada);
        
        if(tipoJornadaData.isPresent()){
            c_TipoJornadaEntity tipoJornada = cTipoJornadaRepository.save(cTipoJornada); 
            return new ResponseEntity<>(tipoJornada, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoJornadaEntity> updatingStatus(@PathVariable("id") String idTipoJornada, @RequestBody c_TipoJornadaEntity cTipoJornada){
        Optional<c_TipoJornadaEntity> tipoJornadaData = cTipoJornadaRepository.findById(idTipoJornada);
        
        if(tipoJornadaData.isPresent()){
            c_TipoJornadaEntity tipoJornada =  tipoJornadaData.get();
            tipoJornada.setStatus(cTipoJornada.getStatus());
            return new ResponseEntity<>(cTipoJornadaRepository.save(tipoJornada),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}