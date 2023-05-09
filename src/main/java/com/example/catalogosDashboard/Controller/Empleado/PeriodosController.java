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

import com.example.catalogosDashboard.Entity.Empleado.PeriodosEntity;
import com.example.catalogosDashboard.Repository.Empleado.PeriodosRepository;
import com.example.catalogosDashboard.Service.Empleado.PeriodosService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Periodos")
public class PeriodosController {

    @Autowired
    PeriodosRepository periodosRepository;

    @Autowired
    PeriodosService periodosService;

    @GetMapping("/sort/{status}")
    public List<PeriodosEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<PeriodosEntity>) periodosService.getAllPeriodosByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<PeriodosEntity> createRegistro(@RequestBody PeriodosEntity var) {
        try {
            PeriodosEntity periodos = periodosRepository.save(var);
            return new ResponseEntity<>(periodos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PeriodosEntity> updatingRegistro(@PathVariable("id") Long idPeriodos, @RequestBody PeriodosEntity cPeriodos){
        Optional <PeriodosEntity> periodosData = periodosRepository.findById(idPeriodos);
        
        if(periodosData.isPresent()){
            PeriodosEntity periodos = periodosRepository.save(cPeriodos);
            return new ResponseEntity<>(periodos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<PeriodosEntity> updatingStatus(@PathVariable("id") Long idPeriodos, @RequestBody PeriodosEntity cPeriodos){
        Optional <PeriodosEntity> periodosData = periodosRepository.findById(idPeriodos);
        
        if(periodosData.isPresent()){
            PeriodosEntity periodos =  periodosData.get();
            periodos.setStatus(cPeriodos.getStatus());
            return new ResponseEntity<>(periodosRepository.save(periodos),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
