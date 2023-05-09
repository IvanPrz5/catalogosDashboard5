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

import com.example.catalogosDashboard.Entity.Empleado.UsuariosNominaEntity;
import com.example.catalogosDashboard.Repository.Empleado.UsuariosNominaRepository;
import com.example.catalogosDashboard.Service.Empleado.UsuariosNominaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/UsuariosNomina")
public class UsuariosNominaController {
    @Autowired
    UsuariosNominaRepository usuariosNominaRepository;

    @Autowired
    UsuariosNominaService usuariosNominaService;

    @GetMapping("/sort/{status}")
    public List<UsuariosNominaEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort){
        return (List<UsuariosNominaEntity>) usuariosNominaService.getAllUsuariosNominaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<UsuariosNominaEntity> createRegistro(@RequestBody UsuariosNominaEntity var) {
        try {
            UsuariosNominaEntity usuariosNomina = usuariosNominaRepository.save(var);
            return new ResponseEntity<>(usuariosNomina, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuariosNominaEntity> updatingRegistro(@PathVariable("id") Long idUsuarioNomina, @RequestBody UsuariosNominaEntity cUsuarioNomina){
        Optional <UsuariosNominaEntity> usuarioNominaData = usuariosNominaRepository.findById(idUsuarioNomina);
        
        if(usuarioNominaData.isPresent()){
            UsuariosNominaEntity usuarioNomina = usuariosNominaRepository.save(cUsuarioNomina);
            return new ResponseEntity<>(usuarioNomina, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<UsuariosNominaEntity> updatingStatus(@PathVariable("id") Long idUsuarioNomina, @RequestBody UsuariosNominaEntity cUsuarioNomina){
        Optional <UsuariosNominaEntity> usuarioNominaData = usuariosNominaRepository.findById(idUsuarioNomina);

        if(usuarioNominaData.isPresent()){
            UsuariosNominaEntity usuarioNomina =  usuarioNominaData.get();
            usuarioNomina.setStatus(cUsuarioNomina.getStatus());
            return new ResponseEntity<>(usuariosNominaRepository.save(usuarioNomina),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
