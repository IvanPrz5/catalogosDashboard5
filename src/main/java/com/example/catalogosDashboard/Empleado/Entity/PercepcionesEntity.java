package com.example.catalogosDashboard.Empleado.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Percepciones")
public class PercepcionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double exento;
    @Column
    private Double agravado;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idEmpresaPercepcion")
    private EmpresaPercepcionEntity empresaPercepcionEntity;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private EmpleadoEntity empleadosEntity;

    @ManyToOne
    @JoinColumn(name = "idPeriodo")
    private PeriodosEntity periodosEntity;

    @ManyToOne
    @JoinColumn(name = "idSubEmpresa")
    private SubEmpresasEntity subEmpresasEntity;

    @ManyToOne
    @JoinColumn(name = "idUsuarioAlta")
    private UsuariosNominaEntity usuariosAltaEntity;

    @ManyToOne
    @JoinColumn(name = "idUsuarioBaja")
    private UsuariosNominaEntity usuariosBajaEntity;
    
}
