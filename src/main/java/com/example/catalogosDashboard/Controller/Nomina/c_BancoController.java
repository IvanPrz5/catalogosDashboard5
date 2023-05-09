package com.example.catalogosDashboard.Controller.Nomina;

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

import com.example.catalogosDashboard.Entity.Nomina.c_BancoEntity;
import com.example.catalogosDashboard.Repository.Nomina.c_BancoRepository;
import com.example.catalogosDashboard.Service.Nomina.c_BancoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Banco")
public class c_BancoController {

    @Autowired
    private c_BancoService cBancoService;

    @Autowired
    private c_BancoRepository cBancoRepository;

    /* @GetMapping
    public List<c_BancoEntity> getAllData(){
        return (List<c_BancoEntity>) cBancoService.getAllBancos();
    }  */

    @GetMapping("/sort/{status}")
    public List<c_BancoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_BancoEntity>) cBancoService.getAllBancosByStatus(status, sort);
    }
    
    @GetMapping(value = "/{id}")
    public Optional<c_BancoEntity> getDataByIdBanco(@PathVariable("id") String id) {
        return cBancoService.getBancoById(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_BancoEntity> createRegistro(@RequestBody c_BancoEntity var) {
        try {
            c_BancoEntity banco = cBancoRepository.save(var);
            return new ResponseEntity<>(banco, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_BancoEntity> updatingRegistro(@PathVariable("id") String idBanco, @RequestBody c_BancoEntity cBanco){
        Optional<c_BancoEntity> bancoData = cBancoRepository.findById(idBanco);
        
        if(bancoData.isPresent()){
            c_BancoEntity banco = cBancoRepository.save(cBanco);
            return new ResponseEntity<>(banco, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_BancoEntity> updatingStatus(@PathVariable("id") String idBanco, @RequestBody c_BancoEntity cBanco){
        Optional<c_BancoEntity> bancoData = cBancoRepository.findById(idBanco);
        if(bancoData.isPresent()){
            c_BancoEntity banco = bancoData.get();
            banco.setStatus(cBanco.getStatus());
            return new ResponseEntity<>(cBancoRepository.save(banco),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /* @DeleteMapping("/{caduana}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("caduana") String caduana) {
        try {
            aduanaRepository.deleteById(caduana);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */

}