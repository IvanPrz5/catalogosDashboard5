package com.example.catalogosDashboard.Empleado.Controller;

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

import com.example.catalogosDashboard.Empleado.Entity.EmpleadoEntity;
import com.example.catalogosDashboard.Empleado.Repository.EmpleadoRepository;
import com.example.catalogosDashboard.Empleado.Service.EmpleadoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT, })
@RestController
@RequestMapping("auth/Empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado/{id}")
    public Optional<EmpleadoEntity> getEmpleadoById(@PathVariable("id") Long idEmpleado){
        return (Optional<EmpleadoEntity>) empleadoRepository.findById(idEmpleado);
    }    

    @GetMapping("/sort/{status}")
    public List<EmpleadoEntity> getDataByStatus(@PathVariable("status") Boolean status, Sort sort) {
        return (List<EmpleadoEntity>) empleadoService.getAllEmpleadosByStatus(status, sort);
    }

    @PostMapping("/agregar")
    public ResponseEntity<EmpleadoEntity> createRegistro(@RequestBody EmpleadoEntity var) {
        try {
            EmpleadoEntity empleado = empleadoRepository.save(var);
            return new ResponseEntity<>(empleado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpleadoEntity> updatingRegistro(@PathVariable("id") Long idEmpleado, @RequestBody EmpleadoEntity cEmpleado) {
        Optional<EmpleadoEntity> empleadoData = empleadoRepository.findById(idEmpleado);

        if (empleadoData.isPresent()) {
            EmpleadoEntity empleado = empleadoRepository.save(cEmpleado);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<EmpleadoEntity> updatingStatus(@PathVariable("id") Long idEmpleado, @RequestBody EmpleadoEntity cEmpleado) {
        Optional<EmpleadoEntity> empleadoData = empleadoRepository.findById(idEmpleado);

        if (empleadoData.isPresent()) {
            EmpleadoEntity empleado = empleadoData.get();
            empleado.setStatus(cEmpleado.getStatus());
            return new ResponseEntity<>(empleadoRepository.save(empleado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
