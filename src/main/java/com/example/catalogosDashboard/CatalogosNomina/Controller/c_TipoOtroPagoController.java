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

import com.example.catalogosDashboard.CatalogosNomina.Entity.c_TipoOtroPagoEntity;
import com.example.catalogosDashboard.CatalogosNomina.Repository.c_TipoOtroPagoRepository;
import com.example.catalogosDashboard.CatalogosNomina.Service.c_TipoOtroPagoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TipoOtroPago")
public class c_TipoOtroPagoController {

    @Autowired
    private c_TipoOtroPagoService cTipoOtroPagoService;

    @Autowired
    private c_TipoOtroPagoRepository cTipoOtroPagoRepository;

    /* @GetMapping
    public List<c_TipoOtroPagoEntity> getAllData(){
        return (List<c_TipoOtroPagoEntity>) cTipoOtroPagoService.getAllTipoOPago();
    }  */

    @GetMapping(value = "/{id}")
    public Optional<c_TipoOtroPagoEntity> getDataByIdTipoOtroPago(@PathVariable("id") String id) {
        return cTipoOtroPagoService.getTipoOtroPagoById(id);
    }

    @GetMapping("/sort/{status}")
    public List<c_TipoOtroPagoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TipoOtroPagoEntity>) cTipoOtroPagoService.getAllTipoOtroPagoByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TipoOtroPagoEntity> createRegistro(@RequestBody c_TipoOtroPagoEntity var) {
        try {
            c_TipoOtroPagoEntity tipoOtroPago = cTipoOtroPagoRepository.save(var);
            return new ResponseEntity<>(tipoOtroPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TipoOtroPagoEntity> updatingRegistro(@PathVariable("id") String idTipoOtroPago, @RequestBody c_TipoOtroPagoEntity cTipoOtroPago){
        Optional<c_TipoOtroPagoEntity> tipoOtroPagoData = cTipoOtroPagoRepository.findById(idTipoOtroPago);
        
        if(tipoOtroPagoData.isPresent()){
            c_TipoOtroPagoEntity tipoOtroPago = cTipoOtroPagoRepository.save(cTipoOtroPago);
            return new ResponseEntity<>(tipoOtroPago, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } 
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TipoOtroPagoEntity> updatingStatus(@PathVariable("id") String idTipoOtroPago, @RequestBody c_TipoOtroPagoEntity cTipoOtroPago){
        Optional<c_TipoOtroPagoEntity> tipoOtroPagoData = cTipoOtroPagoRepository.findById(idTipoOtroPago);
        
        if(tipoOtroPagoData.isPresent()){
            c_TipoOtroPagoEntity tipoOtroPago =  tipoOtroPagoData.get();
            tipoOtroPago.setStatus(cTipoOtroPago.getStatus());
            return new ResponseEntity<>(cTipoOtroPagoRepository.save(tipoOtroPago),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}