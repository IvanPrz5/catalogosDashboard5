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

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresasRepository;
import com.example.catalogosDashboard.Service.Empleado.EmpresasService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Empresas")
public class EmpresasController {

    @Autowired
    EmpresasRepository empresasRepository;

    @Autowired
    EmpresasService empresasService;

    @GetMapping("/sort/{status}")
    public List<EmpresasEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<EmpresasEntity>) empresasService.getAllEmpresasByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<EmpresasEntity> createRegistro(@RequestBody EmpresasEntity var) {
        try {
            EmpresasEntity empresas = empresasRepository.save(var);
            return new ResponseEntity<>(empresas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpresasEntity> updatingRegistro(@PathVariable("id") Long idEmpresa, @RequestBody EmpresasEntity cEmpresa){
        Optional <EmpresasEntity> empresasData = empresasRepository.findById(idEmpresa);
        
        if(empresasData.isPresent()){
            EmpresasEntity empresas = empresasRepository.save(cEmpresa);
            return new ResponseEntity<>(empresas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<EmpresasEntity> updatingStatus(@PathVariable("id") Long idEmpresa, @RequestBody EmpresasEntity cEmpresa){
        Optional <EmpresasEntity> empresasData = empresasRepository.findById(idEmpresa);

        if(empresasData.isPresent()){
            EmpresasEntity empresas =  empresasData.get();
            empresas.setStatus(cEmpresa.getStatus());
            return new ResponseEntity<>(empresasRepository.save(empresas),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
