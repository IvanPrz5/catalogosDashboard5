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

import com.example.catalogosDashboard.Empleado.Entity.EmpresaOtrosPagosEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpresaOtrosPagosRepository;
import com.example.catalogosDashboard.Empleado.Service.EmpresaOtrosPagosService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/EmpresaOtrosPagos")
public class EmpresaOtrosPagosController {
    
    @Autowired
    EmpresaOtrosPagosRepository empresaOtrosPagosRepository;

    @Autowired
    EmpresaOtrosPagosService empresaOtrosPagosService;

    @GetMapping("/sort/{status}")
    public List<EmpresaOtrosPagosEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<EmpresaOtrosPagosEntity>) empresaOtrosPagosService.getAllEmpresaOtrosPagosByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<EmpresaOtrosPagosEntity> createRegistro(@RequestBody EmpresaOtrosPagosEntity var) {
        try {
            EmpresaOtrosPagosEntity empresaOtrosPagos = empresaOtrosPagosRepository.save(var);
            return new ResponseEntity<>(empresaOtrosPagos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpresaOtrosPagosEntity> updatingRegistro(@PathVariable("id") Long idEmpresaOtrosPagos, @RequestBody EmpresaOtrosPagosEntity cEmpresaOtrosPagos){
        Optional <EmpresaOtrosPagosEntity> empresaOtrosPagosData = empresaOtrosPagosRepository.findById(idEmpresaOtrosPagos);
        
        if(empresaOtrosPagosData.isPresent()){
            EmpresaOtrosPagosEntity empresaOtrosPagos = empresaOtrosPagosRepository.save(cEmpresaOtrosPagos);
            return new ResponseEntity<>(empresaOtrosPagos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<EmpresaOtrosPagosEntity> updatingStatus(@PathVariable("id") Long idEmpresaOtrosPagos, @RequestBody EmpresaOtrosPagosEntity cEmpresaOtrosPagos){
        Optional <EmpresaOtrosPagosEntity> empresaOtrosPagosData = empresaOtrosPagosRepository.findById(idEmpresaOtrosPagos);
        
        if(empresaOtrosPagosData.isPresent()){
            EmpresaOtrosPagosEntity empresaOtrosPagos =  empresaOtrosPagosData.get();
            empresaOtrosPagos.setStatus(cEmpresaOtrosPagos.getStatus());
            return new ResponseEntity<>(empresaOtrosPagosRepository.save(empresaOtrosPagos),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
