package com.example.catalogosDashboard.Controller.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasUsersEntity;
import com.example.catalogosDashboard.Service.Empleado.SubEmpresasUsersService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT, })
@RestController
@RequestMapping("auth/SubEmpresasUsers")
public class SubEmpresasUsersController {

    @Autowired
    SubEmpresasUsersService subEmpresasUsersService;

    @Transactional
    @GetMapping("/prueba/{idUsuario}/{idEmpresa}/{status}")
    public List<SubEmpresasUsersEntity> byIdUsuarioAndIdEmpresaAndIdSubEmpresaAndStatus(
            @PathVariable("idUsuario") Integer idUsuario, 
            @PathVariable("idEmpresa") Long idEmpresa,
            @PathVariable("status") Boolean status) {
        return (List<SubEmpresasUsersEntity>) subEmpresasUsersService.getByIdUsuarioAndIdEmpresaAndStatus(idUsuario,
                idEmpresa, status);
    }

    /*
     * @Transactional
     * 
     * @GetMapping("/prueba/{idUsuario}/{idEmpresa}/{idSubEmpresa}")
     * public List<SubEmpresasUsersEntity>
     * byIdUsuarioAndIdEmpresaAndIdSubEmpresa(@PathVariable("idUsuario") Integer
     * idUsuario, @PathVariable("idEmpresa") Long idEmpresa,
     * 
     * @PathVariable("idSubEmpresa") Long idSubEmpresa){
     * return (List<SubEmpresasUsersEntity>)
     * subEmpresasUsersService.getByIdUsuarioAndIdEmpresaAndIdSubEmpresa(idUsuario,
     * idEmpresa, idSubEmpresa);
     * }
     */
}
