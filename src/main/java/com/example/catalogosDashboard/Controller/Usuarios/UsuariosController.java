package com.example.catalogosDashboard.Controller.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.Usuarios.UsuariosEntity;
import com.example.catalogosDashboard.Repository.Usuarios.UsuariosRepository;

import org.springframework.http.HttpStatus;

import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/user")
public class UsuariosController {
    
    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping(value = "/information/{email}")
    public Optional <UsuariosEntity> getDataByIdUsuario(@PathVariable("email") String email){
        return usuariosRepository.findOneByEmail(email);
    }

    /* @GetMapping("/relationed/{email}/{idSubEmpresa}")
    public List<UsuariosEntity> getDataByStatus(@PathVariable("email") String email, Long idSubEmpresa){
        return (List<PuestoEntity>) puestoService.getAllPuestoByStatus(email, idSubEmpresa);
    } */    

    @PutMapping("updateAccount/{id}")
    public ResponseEntity<UsuariosEntity> updatePerfil(@PathVariable("id") Integer idUsuario, @RequestBody UsuariosEntity usuarioParam){
        Optional <UsuariosEntity> usuarioInfo = usuariosRepository.findById(idUsuario);

        if(usuarioInfo.isPresent()){
            UsuariosEntity var = usuarioInfo.get();
            var.setNombre(usuarioParam.getNombre());
            var.setApPaterno(usuarioParam.getApPaterno());
            var.setApMaterno(usuarioParam.getApMaterno());
            var.setEmail(usuarioParam.getEmail());
            var.setUserName(usuarioParam.getUserName());
          
            return new ResponseEntity<>(usuariosRepository.save(var), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
