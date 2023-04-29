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

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_NumPedAduana;
import com.example.catalogosDashboard.CatalogosCFDI.Repository.c_NumPedAduanaRepository;
import com.example.catalogosDashboard.CatalogosCFDI.Service.c_NumPedAduanaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })

@RestController
@RequestMapping("auth/NumPedAduana")
public class c_NumPedAduanaController {

    @Autowired
    private c_NumPedAduanaRepository cNumPedAduanaRepository;

    @Autowired
    private c_NumPedAduanaService cNumPedAduanaService;

    /* @GetMapping
    public List<c_NumPedAduana> getAllData() {
        return (List<c_NumPedAduana>) numpedaduanaRepository.findAll();
    }
 */
    @GetMapping(value = "/{id}")
    public Optional<c_NumPedAduana> data(@PathVariable("id") Integer id) {
        return cNumPedAduanaRepository.findById(id);
    }
    
    @GetMapping("/sort/{status}")
    public List<c_NumPedAduana> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<c_NumPedAduana>) cNumPedAduanaService.getAllNumPedAduanaByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_NumPedAduana> createRegistro(@RequestBody c_NumPedAduana var) {
        try {
            c_NumPedAduana nPedAduana = cNumPedAduanaRepository.save(var);
            return new ResponseEntity<>(nPedAduana, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_NumPedAduana> updatingRegistro(@PathVariable("id") Integer idNPAduna, @RequestBody c_NumPedAduana cNPAduana){
        Optional<c_NumPedAduana> npAduanaData = cNumPedAduanaRepository.findById(idNPAduna);
        
        if(npAduanaData.isPresent()){
            c_NumPedAduana nPedAduana = npAduanaData.get();
            // nPedAduana.setCod(cNPAduana.getCod());
            nPedAduana.setPatente(cNPAduana.getPatente());
            nPedAduana.setStatus(cNPAduana.getStatus());
            return new ResponseEntity<>(cNumPedAduanaRepository.save((nPedAduana)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_NumPedAduana> updatingStatus(@PathVariable("id") Integer idNPAduna, @RequestBody c_NumPedAduana cNPAduana){
        Optional<c_NumPedAduana> npAduanaData = cNumPedAduanaRepository.findById(idNPAduna);
        
        if(npAduanaData.isPresent()){
            c_NumPedAduana nPedAduana = npAduanaData.get();
            nPedAduana.setStatus(cNPAduana.getStatus());
            return new ResponseEntity<>(cNumPedAduanaRepository.save(nPedAduana),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
