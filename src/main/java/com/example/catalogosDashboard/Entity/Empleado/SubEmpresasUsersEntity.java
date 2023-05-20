package com.example.catalogosDashboard.Entity.Empleado;

import com.example.catalogosDashboard.Entity.Usuarios.UsuariosEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SubEmpresasUsers")
public class SubEmpresasUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuariosEntity idUsuario;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private EmpresasEntity idEmpresa;

    @ManyToOne
    @JoinColumn(name = "idSubEmpresa")
    private SubEmpresasEntity idSubEmpresa;

    @Column
    private Boolean status;
}
