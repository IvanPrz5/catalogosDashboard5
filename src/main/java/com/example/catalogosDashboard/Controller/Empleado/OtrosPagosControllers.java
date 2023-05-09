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

import com.example.catalogosDashboard.Entity.Empleado.OtrosPagosEntity;
import com.example.catalogosDashboard.Repository.Empleado.OtrosPagosRepository;
import com.example.catalogosDashboard.Service.Empleado.OtrosPagosService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/OtrosPagos")
public class OtrosPagosControllers {

    @Autowired
    OtrosPagosRepository otrosPagosRepository;

    @Autowired
    OtrosPagosService otrosPagosService;

    @GetMapping("/sort/{status}")
    public List<OtrosPagosEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<OtrosPagosEntity>) otrosPagosService.getAllOtrosPagosByStatus(status, sort);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<OtrosPagosEntity> createRegistro(@RequestBody OtrosPagosEntity var) {
        try {
            OtrosPagosEntity otrosPagos = otrosPagosRepository.save(var);
            return new ResponseEntity<>(otrosPagos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<OtrosPagosEntity> updatingRegistro(@PathVariable("id") Long idOtrosPagos, @RequestBody OtrosPagosEntity cOtrosPagos){
        Optional <OtrosPagosEntity> otrosPagosData = otrosPagosRepository.findById(idOtrosPagos);
        
        if(otrosPagosData.isPresent()){
            OtrosPagosEntity otrosPagos = otrosPagosRepository.save(cOtrosPagos);
            return new ResponseEntity<>(otrosPagos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<OtrosPagosEntity> updatingStatus(@PathVariable("id") Long idOtrosPagos, @RequestBody OtrosPagosEntity cOtrosPagos){
        Optional <OtrosPagosEntity> otrosPagosData = otrosPagosRepository.findById(idOtrosPagos);

        if(otrosPagosData.isPresent()){
            OtrosPagosEntity otrosPagos =  otrosPagosData.get();
            otrosPagos.setStatus(cOtrosPagos.getStatus());
            return new ResponseEntity<>(otrosPagosRepository.save(otrosPagos),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
