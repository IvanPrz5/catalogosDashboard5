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

import com.example.catalogosDashboard.Entity.Empleado.EmpresaDeduccionEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresaDeduccionRepository;
import com.example.catalogosDashboard.Service.Empleado.EmpresaDeduccionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/EmpresaDeducciones")
public class EmpresaDeduccionController {
    
    @Autowired
    EmpresaDeduccionRepository empresaDeduccionRepository;

    @Autowired
    EmpresaDeduccionService empresaDeduccionService;

    @GetMapping("/sort/{status}")
    public List<EmpresaDeduccionEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<EmpresaDeduccionEntity>) empresaDeduccionService.getAllEmpresaDeduccionByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<EmpresaDeduccionEntity> createRegistro(@RequestBody EmpresaDeduccionEntity var) {
        try {
            EmpresaDeduccionEntity empresaDeducciones = empresaDeduccionRepository.save(var);
            return new ResponseEntity<>(empresaDeducciones, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpresaDeduccionEntity> updatingRegistro(@PathVariable("id") Long idEmpresaDeduccion, @RequestBody EmpresaDeduccionEntity cEmpresaDeduccion){
        Optional <EmpresaDeduccionEntity> empresaDeduccionData = empresaDeduccionRepository.findById(idEmpresaDeduccion);
        
        if(empresaDeduccionData.isPresent()){
            EmpresaDeduccionEntity empresaDeduccion = empresaDeduccionRepository.save(cEmpresaDeduccion);
            return new ResponseEntity<>(empresaDeduccion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<EmpresaDeduccionEntity> updatingStatus(@PathVariable("id") Long idEmpresaDeduccion, @RequestBody EmpresaDeduccionEntity cEmpresaDeduccion){
        Optional <EmpresaDeduccionEntity> empresaDeduccionData = empresaDeduccionRepository.findById(idEmpresaDeduccion);

        if(empresaDeduccionData.isPresent()){
            EmpresaDeduccionEntity empresaDeduccion =  empresaDeduccionData.get();
            empresaDeduccion.setStatus(cEmpresaDeduccion.getStatus());
            return new ResponseEntity<>(empresaDeduccionRepository.save(empresaDeduccion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
