package com.example.catalogosDashboard.Empleado.Entity;

import java.time.LocalDate;

import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Asentamientos;
import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Estado;
import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Localidad;
import com.example.catalogosDashboard.CatalogosCFDI.Entity.c_Municipio;
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
@Table(name="Empleado")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String paterno;
    @Column
    private String materno;
    @Column 
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaContratacion;
    @Column
    private Long satTipoContrato;
    @Column
    private Double salarioDiario;
    @Column
    private Double salarioDiarioIntegrado;
    @Column
    private Long satTipoRegimen;
    @Column
    private Long satTipoJornada;
    @Column
    private String satBanco;
    @Column
    private Long cuentaBanco;
    @Column
    private Long satRiesgoPuesto;
    @Column
    private Long numeroSeguro;
    @Column
    private Long numeroInfonavit;
    @Column
    private Long registroPatronal;
    @Column
    private String rfc;
    @Column
    private String curp;
    @Column
    private String calle;
    @Column
    private String numeroExt;
    /* @Column
    private Long numeroInfonavit2; */
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idSubEmpresa")
    private SubEmpresasEntity subEmpresasEntity;

    @ManyToOne
    @JoinColumn(name = "idPuesto")
    private PuestoEntity puestoEntity;

    @ManyToOne 
    @JoinColumn(name = "idDepartamento")
    private DepartamentoEntity departamentoEntity;

    @ManyToOne
    @JoinColumn(name = "idSindicato")
    private SindicatoEntity sindicatoEntity;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private c_Estado estadoEntity;

    @ManyToOne
    @JoinColumn(name = "idMunicipio")
    private c_Municipio municipioEntity;

    @ManyToOne
    @JoinColumn(name = "idLocalidad")
    private c_Localidad localidadEntity;

    @ManyToOne
    @JoinColumn(name = "idAsentamientos")
    private c_Asentamientos asentamientosEntity;
}
