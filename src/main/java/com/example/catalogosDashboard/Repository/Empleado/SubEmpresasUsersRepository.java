package com.example.catalogosDashboard.Repository.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogosDashboard.Entity.Empleado.EmpresasEntity;
import com.example.catalogosDashboard.Entity.Empleado.SubEmpresasUsersEntity;
import com.example.catalogosDashboard.Entity.Usuarios.UsuariosEntity;

public interface SubEmpresasUsersRepository extends JpaRepository<SubEmpresasUsersEntity, Long> {
    List<SubEmpresasUsersEntity> findByIdUsuarioAndIdEmpresaAndStatus(UsuariosEntity idUsuario, EmpresasEntity idEmpresa, Boolean status);    
}
