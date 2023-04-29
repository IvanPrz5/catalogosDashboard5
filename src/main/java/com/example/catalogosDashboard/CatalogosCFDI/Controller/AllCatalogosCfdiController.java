package com.example.catalogosDashboard.CatalogosCFDI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.AllCatalogosCfdiEntity;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.AllCatalogosCfdiRepository;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Catalogos/Cfdi")
public class AllCatalogosCfdiController {
    
    @Autowired
    private AllCatalogosCfdiRepository catalogosCfdiRepository;

    @GetMapping
    public List<AllCatalogosCfdiEntity> getAllData(){
        return (List<AllCatalogosCfdiEntity>) catalogosCfdiRepository.findAll();
    } 
}

