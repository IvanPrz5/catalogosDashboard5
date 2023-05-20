package com.example.catalogosDashboard.Service.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasUsersEntity;
import com.example.catalogosDashboard.Entity.Usuarios.UsuariosEntity;
import com.example.catalogosDashboard.Repository.Empleado.EmpresasRepository;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasRepository;
import com.example.catalogosDashboard.Repository.Empleado.SubEmpresasUsersRepository;
import com.example.catalogosDashboard.Repository.Usuarios.UsuariosRepository;

@Service
public class SubEmpresasUsersService {
    @Autowired
    SubEmpresasUsersRepository subEmpresasUsersRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    EmpresasRepository empresasRepository;

    @Autowired
    SubEmpresasRepository subEmpresasRepository;

    public List<SubEmpresasUsersEntity> getByIdUsuarioAndIdEmpresaAndStatus(Integer idUsuario, Long idEmpresa, Boolean status) {

        Optional<UsuariosEntity> usuariosEntity = usuariosRepository.findById(idUsuario);
        UsuariosEntity usuariosId = usuariosEntity.get();

        Optional<EmpresasEntity> empresasEntity = empresasRepository.findById(idEmpresa);
        EmpresasEntity empresasId = empresasEntity.get();

        List<SubEmpresasUsersEntity> subEmpresasUsers = subEmpresasUsersRepository
                .findByIdUsuarioAndIdEmpresaAndStatus(usuariosId, empresasId, status);
        return subEmpresasUsers;
    }
}
