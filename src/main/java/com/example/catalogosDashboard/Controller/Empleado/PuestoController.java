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

import com.example.catalogosDashboard.Entity.Empleado.PuestoEntity;
import com.example.catalogosDashboard.Repository.Empleado.PuestoRepository;
import com.example.catalogosDashboard.Service.Empleado.PuestoService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Puesto")
public class PuestoController {

    @Autowired
    PuestoRepository puestoRepository;

    @Autowired
    PuestoService puestoService;

    @GetMapping("/sort/{status}")
    public List<PuestoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<PuestoEntity>) puestoService.getAllPuestoByStatus(status, sort);
    }    

    @PostMapping("/agregar")
    public ResponseEntity<PuestoEntity> createRegistro(@RequestBody PuestoEntity var) {
        try {
            PuestoEntity puesto = puestoRepository.save(var);
            return new ResponseEntity<>(puesto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PuestoEntity> updatingRegistro(@PathVariable("id") Long idPuesto, @RequestBody PuestoEntity cPuesto){
        Optional <PuestoEntity> puestoData = puestoRepository.findById(idPuesto);
        
        if(puestoData.isPresent()){
            PuestoEntity puesto = puestoRepository.save(cPuesto);
            return new ResponseEntity<>(puesto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<PuestoEntity> updatingStatus(@PathVariable("id") Long idPuesto, @RequestBody PuestoEntity cPuesto){
        Optional <PuestoEntity> puestoData = puestoRepository.findById(idPuesto);

        if(puestoData.isPresent()){
            PuestoEntity puesto =  puestoData.get();
            puesto.setStatus(cPuesto.getStatus());
            return new ResponseEntity<>(puestoRepository.save(puesto),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
