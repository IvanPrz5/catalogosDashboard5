package com.example.catalogosDashboard.Controller.CFDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.CFDI.c_Asentamientos;
import com.example.catalogosDashboard.Repository.CFDI.c_AsentamientosRepository;
import com.example.catalogosDashboard.Service.CFDI.c_AsentamientosService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Asentamientos")
public class c_AsentamientosController {
    @Autowired
    private c_AsentamientosRepository asentamientosRepository;

    @Autowired
    private c_AsentamientosService asentamientosService;

    @GetMapping(value = "/{id}")
    public Optional<c_Asentamientos> data(@PathVariable("id") String id) {
        return asentamientosRepository.findById(id);
    }

    @Transactional
    @GetMapping("/byIdCodPostal/{id}/{status}")
    public List<c_Asentamientos> byIdCodigoPostalAndStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status, Sort sort){
        return (List<c_Asentamientos>) asentamientosService.getByIdCodigoPostalAndStatus(id, status, sort);
    }

    @GetMapping("/sort")
    public ResponseEntity<Page<c_Asentamientos>> getAllAsentamientos(@RequestParam(required = false, defaultValue = "0") Integer page, 
    @RequestParam(required = false, defaultValue = "10") Integer size, 
    @RequestParam(required = false, defaultValue = "false") Boolean enablePagination)
    {
        return ResponseEntity.ok(asentamientosService.paginas(page, size, enablePagination));
    }

    @PostMapping("/agregar")
    public ResponseEntity<c_Asentamientos> createRegistro(@RequestBody c_Asentamientos var) {
        try {
            c_Asentamientos asentamientos = asentamientosRepository.save(var);
            return new ResponseEntity<>(asentamientos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<c_Asentamientos> updatingRegistro(@PathVariable("id") String idAsentamientos,
            @RequestBody c_Asentamientos cAsentamientos) {
        Optional<c_Asentamientos> asentamientosData = asentamientosRepository.findById(idAsentamientos);

        if (asentamientosData.isPresent()) {
            c_Asentamientos asentamientos = asentamientosData.get();
            asentamientos.setCod(cAsentamientos.getCod());
            asentamientos.setNombre(cAsentamientos.getNombre());
            asentamientos.setTipo(cAsentamientos.getTipo());
            asentamientos.setIdCodigoPostal(cAsentamientos.getIdCodigoPostal());
            asentamientos.setStatus(cAsentamientos.getStatus());
            return new ResponseEntity<>(asentamientosRepository.save(asentamientos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<c_Asentamientos> updatingStatus(@PathVariable("id") String idAsentamientos,
            @RequestBody c_Asentamientos cAsentamientos) {
        Optional<c_Asentamientos> asentamientosData = asentamientosRepository.findById(idAsentamientos);

        if (asentamientosData.isPresent()) {
            c_Asentamientos asentamientos = asentamientosData.get();
            asentamientos.setStatus(asentamientos.getStatus());
            return new ResponseEntity<>(asentamientosRepository.save(asentamientos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
