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

import com.example.catalogosDashboard.Entity.Nomina.c_TipoHorasEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_TipoHorasRepository;
import com.example.catalogosDashboard.Service.Nomina.c_TipoHorasService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoHoras")
public class c_TipoHorasController {

    @Autowired
    private c_TipoHorasService cTipoHorasService;

    @Autowired
    private c_TipoHorasRepository cTipoHorasRepository;

    /* @GetMapping
    public List<c_TipoHorasEntity> getAllData(){
        return (List<c_TipoHorasEntity>) cTipoHorasService.getAllTipoHoras();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoHorasEntity> getDataByIdTipoHoras(@PathVariable("id") String id) {
        return cTipoHorasService.getTipoHorasById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoHorasEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoHorasEntity>) cTipoHorasService.getAllTipoHorasByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoHorasEntity> createRegistro(@RequestBody c_TipoHorasEntity var) {
        try {
            c_TipoHorasEntity tipoHoras = cTipoHorasRepository.save(var);
            return new ResponseEntity<>(tipoHoras, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoHorasEntity> updatingRegistro(@PathVariable("id") String idTipoHoras, @RequestBody c_TipoHorasEntity cTipoHoras){
        Optional<c_TipoHorasEntity> tipoHorasData = cTipoHorasRepository.findById(idTipoHoras);
        
        if(tipoHorasData.isPresent()){
            c_TipoHorasEntity tipoHoras = cTipoHorasRepository.save(cTipoHoras); 
            return new ResponseEntity<>(tipoHoras, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoHorasEntity> updatingStatus(@PathVariable("id") String idTipoHoras, @RequestBody c_TipoHorasEntity cTipoHoras){
        Optional<c_TipoHorasEntity> tipoHorasData = cTipoHorasRepository.findById(idTipoHoras);
        
        if(tipoHorasData.isPresent()){
            c_TipoHorasEntity tipoHoras =  tipoHorasData.get();
            tipoHoras.setStatus(cTipoHoras.getStatus());
            return new ResponseEntity<>(cTipoHorasRepository.save(tipoHoras),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    /* @GetMapping(value = "/{id}")
    public Optional<c_PeriodicidadPagoEntity> getDataByIdBanco(@PathVariable("id") String id) {
        return cPeriodicidadPagoService.getBancoById(id);
    } */
}