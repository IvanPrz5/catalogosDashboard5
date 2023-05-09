package com.example.catalogosDashboard.Controller.Nomina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.Nomina.AllCatalogosNominaEntity;
import com.example.catalogosDashboard.Repository.Nomina.AllCatalogosNominaRepository;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Catalogos/Nomina")
public class AllCatalogosNominaController {
    @Autowired
    private AllCatalogosNominaRepository catalogosRepository;

    @GetMapping
    public List<AllCatalogosNominaEntity> getAllData(){
        return (List<AllCatalogosNominaEntity>) catalogosRepository.findAll();
    } 
}
