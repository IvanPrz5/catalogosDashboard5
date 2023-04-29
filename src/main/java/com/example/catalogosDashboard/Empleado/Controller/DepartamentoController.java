package com.example.catalogosDashboard.Empleado.Controller;

import java.util.List;
import java.util.Optional;

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

import com.example.catalogosDashboard.Empleado.Entity.DepartamentoEntity;
import com.example.catalogosDashboard.Empleado.Repository.DepartamentoRepository;
import com.example.catalogosDashboard.Empleado.Service.DepartamentoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/sort/{status}")
    public List<DepartamentoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<DepartamentoEntity>) departamentoService.getAllDepartamentoByStatus(status, sort);
    }    

    @PostMapping("/agregar")
    public ResponseEntity<DepartamentoEntity> createRegistro(@RequestBody DepartamentoEntity var) {
        try {
            DepartamentoEntity departamento = departamentoRepository.save(var);
            return new ResponseEntity<>(departamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DepartamentoEntity> updatingRegistro(@PathVariable("id") Long idDepartamento, @RequestBody DepartamentoEntity cDepartamento){
        Optional <DepartamentoEntity> departamentoData = departamentoRepository.findById(idDepartamento);
        
        if(departamentoData.isPresent()){
            DepartamentoEntity departamento = departamentoRepository.save(cDepartamento);
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<DepartamentoEntity> updatingStatus(@PathVariable("id") Long idDepartamento, @RequestBody DepartamentoEntity cDepartamento){
        Optional <DepartamentoEntity> departamentoData = departamentoRepository.findById(idDepartamento);

        if(departamentoData.isPresent()){
            DepartamentoEntity departamento =  departamentoData.get();
            departamento.setStatus(cDepartamento.getStatus());
            return new ResponseEntity<>(departamentoRepository.save(departamento),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
