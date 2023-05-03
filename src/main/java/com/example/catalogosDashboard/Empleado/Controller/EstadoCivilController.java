package com.example.catalogosDashboard.Empleado.Controller;

import java.util.List;

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

import com.example.catalogosDashboard.Empleado.Entity.EstadoCivilEntity;
import com.example.catalogosDashboard.Empleado.Repository.EstadoCivilRepository;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/EstadoCivil")
public class EstadoCivilController {
    
    @Autowired
    EstadoCivilRepository estadoCivilRepository;

    @GetMapping()
    public List<EstadoCivilEntity> getAllEstadoCivil() {
        return (List<EstadoCivilEntity>) estadoCivilRepository.findAll();
    }
}
