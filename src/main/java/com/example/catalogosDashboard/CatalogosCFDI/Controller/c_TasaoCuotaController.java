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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_TasaoCuota;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_TasaoCuotaRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_TasaoCuotaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/TasaoCuota")
public class c_TasaoCuotaController {
    @Autowired
    private c_TasaoCuotaRepository tasaCuotaRepository;

    @Autowired
    private c_TasaoCuotaService tasaCuotaService;


    @GetMapping(value = "/{id}")
    public Optional<c_TasaoCuota> data(@PathVariable("id") Integer id) {
        return tasaCuotaRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_TasaoCuota> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_TasaoCuota>) tasaCuotaService.getAllTasaoCoutaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_TasaoCuota> createRegistro(@RequestBody c_TasaoCuota var) {
        try {
            c_TasaoCuota tasaoCuota = tasaCuotaRepository.save(var);
            return new ResponseEntity<>(tasaoCuota, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_TasaoCuota> updatingRegistro(@PathVariable("id") Integer idTasaCuota, @RequestBody c_TasaoCuota cTasaoCuota){
        Optional<c_TasaoCuota> tasacuotaData = tasaCuotaRepository.findById(idTasaCuota);
        
        if(tasacuotaData.isPresent()){
            c_TasaoCuota tasaoCuota = tasacuotaData.get();
            tasaoCuota.setRangoFijo(cTasaoCuota.getRangoFijo());
            tasaoCuota.setValorMinimo(cTasaoCuota.getValorMinimo());
            tasaoCuota.setValorMaximo(cTasaoCuota.getValorMaximo());
            tasaoCuota.setImpuesto(cTasaoCuota.getImpuesto());
            tasaoCuota.setFactor(cTasaoCuota.getFactor());
            tasaoCuota.setTraslado(cTasaoCuota.getTraslado());
            tasaoCuota.setRetencion(cTasaoCuota.getRetencion());
            tasaoCuota.setStatus(cTasaoCuota.getStatus());
            return new ResponseEntity<>(tasaCuotaRepository.save((tasaoCuota)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_TasaoCuota> updatingstatus(@PathVariable("id") Integer idTasaCuota, @RequestBody c_TasaoCuota cTasaoCuota){
        Optional<c_TasaoCuota> tasacuotaData = tasaCuotaRepository.findById(idTasaCuota);
        
        if(tasacuotaData.isPresent()){
            c_TasaoCuota tasaoCuota = tasacuotaData.get();
            tasaoCuota.setStatus(cTasaoCuota.getStatus());
            return new ResponseEntity<>(tasaCuotaRepository.save(tasaoCuota),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
