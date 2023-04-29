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

import com.example.catalogosDashboard.Empleado.Entity.EmpresaPercepcionEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpresaPercepcionRepository;
import com.example.catalogosDashboard.Empleado.Service.EmpresaPercepcionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/EmpresaPercepcion")
public class EmpresaPercepcionController {

    @Autowired
    EmpresaPercepcionRepository empresaPercepcionRepository;

    @Autowired
    EmpresaPercepcionService empresaPercepcionService;

    @GetMapping("/sort/{status}")
    public List<EmpresaPercepcionEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<EmpresaPercepcionEntity>) empresaPercepcionService.getAllEmpresaPercepcionByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<EmpresaPercepcionEntity> createRegistro(@RequestBody EmpresaPercepcionEntity var) {
        try {
            EmpresaPercepcionEntity empresaPercepcion = empresaPercepcionRepository.save(var);
            return new ResponseEntity<>(empresaPercepcion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpresaPercepcionEntity> updatingRegistro(@PathVariable("id") Long idEmpresaPercepcion, @RequestBody EmpresaPercepcionEntity cEmpresaPercepcion){
        Optional <EmpresaPercepcionEntity> empresaPercepcionData = empresaPercepcionRepository.findById(idEmpresaPercepcion);
        
        if(empresaPercepcionData.isPresent()){
            EmpresaPercepcionEntity empresaPercepcion = empresaPercepcionRepository.save(cEmpresaPercepcion);
            return new ResponseEntity<>(empresaPercepcion,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<EmpresaPercepcionEntity> updatingStatus(@PathVariable("id") Long idEmpresaPercepcion, @RequestBody EmpresaPercepcionEntity cEmpresaPercepcion){
        Optional <EmpresaPercepcionEntity> empresaPercepcionData = empresaPercepcionRepository.findById(idEmpresaPercepcion);

        if(empresaPercepcionData.isPresent()){
            EmpresaPercepcionEntity empresaPercepcion =  empresaPercepcionData.get();
            empresaPercepcion.setStatus(cEmpresaPercepcion.getStatus());
            return new ResponseEntity<>(empresaPercepcionRepository.save(empresaPercepcion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
