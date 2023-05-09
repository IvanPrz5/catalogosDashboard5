package com.example.catalogosDashboard.Controller.CFDI;

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

import com.example.catalogosDashboard.Entity.CFDI.c_Exportacion;
import com.example.catalogosDashboard.Repository.CFDI.c_ExportacionRepository;
import com.example.catalogosDashboard.Service.CFDI.c_ExportacionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Exportacion")
public class c_ExportacionController {
    @Autowired
    private c_ExportacionRepository cExportacionRepository;

    @Autowired
    private c_ExportacionService cExportacionService;

    /* @GetMapping
    public List<c_Exportacion> getAllData() {
        return (List<c_Exportacion>) exportacionRepository.findAll();
    } */

    @GetMapping(value = "/{id}")
    public Optional<c_Exportacion> data(@PathVariable("id") String id) {
        return cExportacionRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_Exportacion> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_Exportacion>) cExportacionService.getAllExportacionByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Exportacion> createRegistro(@RequestBody c_Exportacion var) {
        try {
            c_Exportacion exportacion = cExportacionRepository.save(var);
            return new ResponseEntity<>(exportacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Exportacion> updatingRegistro(@PathVariable("id") String idExportacion, @RequestBody c_Exportacion cExportacion){
        Optional<c_Exportacion> exportacionData = cExportacionRepository.findById(idExportacion);
        
        if(exportacionData.isPresent()){
            c_Exportacion exportacion = exportacionData.get();
            exportacion.setDescripcion(cExportacion.getDescripcion());
            exportacion.setStatus(cExportacion.getStatus());
            return new ResponseEntity<>(cExportacionRepository.save((exportacion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Exportacion> updatingStatus(@PathVariable("id") String idExportacion, @RequestBody c_Exportacion cExportacion){
        Optional<c_Exportacion> exportacionData = cExportacionRepository.findById(idExportacion);
        
        if(exportacionData.isPresent()){
            c_Exportacion exportacion = exportacionData.get();
            exportacion.setStatus(cExportacion.getStatus());
            return new ResponseEntity<>(cExportacionRepository.save(exportacion),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
