package com.example.catalogosDashboard.CatalogosCFDI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_UsoCFDI;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_UsoCFDIRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_UsoCFDIService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/UsoCFDI")
public class c_UsoCFDIController {
    @Autowired
    private c_UsoCFDIRepository usoCfdiRepository;

    @Autowired
    private c_UsoCFDIService usoCfdiService;

    /* @GetMapping
    public List<c_UsoCFDI> getAllData() {
        return (List<c_UsoCFDI>) usocfdiRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_UsoCFDI> data(@PathVariable("id") String id) {
        return usoCfdiRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_UsoCFDI> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_UsoCFDI>) usoCfdiService.getAllUsoCFDIByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_UsoCFDI> createRegistro(@RequestBody c_UsoCFDI var) {
        try {
            c_UsoCFDI usoCFDI = usoCfdiRepository.save(var);
            return new ResponseEntity<>(usoCFDI, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_UsoCFDI> updatingRegistro(@PathVariable("id") String idUsoCFDI, @RequestBody c_UsoCFDI cUsoCFDI){
        Optional<c_UsoCFDI> usocfdiData = usoCfdiRepository.findById(idUsoCFDI);
        
        if(usocfdiData.isPresent()){
            c_UsoCFDI usoCFDI = usocfdiData.get();
            usoCFDI.setDescripcion(cUsoCFDI.getDescripcion());
            usoCFDI.setRegimenFiscalReceptor(cUsoCFDI.getRegimenFiscalReceptor());
            usoCFDI.setFisica(cUsoCFDI.getFisica());
            usoCFDI.setMoral(cUsoCFDI.getMoral());
            usoCFDI.setStatus(cUsoCFDI.getStatus());
            return new ResponseEntity<>(usoCfdiRepository.save((usoCFDI)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_UsoCFDI> updatingStatus(@PathVariable("id") String idUsoCFDI, @RequestBody c_UsoCFDI cUsoCFDI){
        Optional<c_UsoCFDI> usocfdiData = usoCfdiRepository.findById(idUsoCFDI);
        
        if(usocfdiData.isPresent()){
            c_UsoCFDI usoCFDI = usocfdiData.get();
            usoCFDI.setStatus(cUsoCFDI.getStatus());
            return new ResponseEntity<>(usoCfdiRepository.save(usoCFDI),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
