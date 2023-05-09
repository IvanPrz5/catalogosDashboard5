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

import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;
import com.example.catalogosDashboard.Service.Empleado.SubEmpresasService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/SubEmpresas")
public class SubEmpresasController {
    
    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    @Autowired
    SubEmpresasService subEmpresasService;

    @GetMapping("/sort/{status}")
    public List<SubEmpresasEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<SubEmpresasEntity>) subEmpresasService.getAllSubEmpresasByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<SubEmpresasEntity> createRegistro(@RequestBody SubEmpresasEntity var) {
        try {
            SubEmpresasEntity subEmpresas = subEmpresasRepository.save(var);
            return new ResponseEntity<>(subEmpresas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<SubEmpresasEntity> updatingRegistro(@PathVariable("id") Long idSubEmpresa, @RequestBody SubEmpresasEntity cSubEmpresa){
        Optional <SubEmpresasEntity> subEmpresaData = subEmpresasRepository.findById(idSubEmpresa);
        
        if(subEmpresaData.isPresent()){
            SubEmpresasEntity subEmpresa = subEmpresasRepository.save(cSubEmpresa);
            return new ResponseEntity<>(subEmpresa, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<SubEmpresasEntity> updatingStatus(@PathVariable("id") Long idSubEmpresa, @RequestBody SubEmpresasEntity cSubEmpresa){
        Optional <SubEmpresasEntity> subEmpresaData = subEmpresasRepository.findById(idSubEmpresa);

        if(subEmpresaData.isPresent()){
            SubEmpresasEntity subEmpresa =  subEmpresaData.get();
            subEmpresa.setStatus(cSubEmpresa.getStatus());
            return new ResponseEntity<>(subEmpresasRepository.save(subEmpresa),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}