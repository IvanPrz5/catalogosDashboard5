package com.example.catalogosDashboard.Entity.Empleado;

import java.time.LocalDate;

import com.example.catalogosDashboard.Entity.CFDI.c_Asentamientos;
import com.example.catalogosDashboard.Entity.CFDI.c_Estado;
import com.example.catalogosDashboard.Entity.CFDI.c_Localidad;
import com.example.catalogosDashboard.Entity.CFDI.c_Municipio;
import com.example.catalogosDashboard.Entity.Nomina.c_BancoEntity;
import com.example.catalogosDashboard.Entity.Nomina.c_RiesgoPuestoEntity;
import com.example.catalogosDashboard.Entity.Nomina.c_TipoContratoEntity;
import com.example.catalogosDashboard.Entity.Nomina.c_TipoJornadaEntity;
import com.example.catalogosDashboard.Entity.Nomina.c_TipoRegimenEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @NonNull
    private String nombre;
    @Column
    @NonNull
    private String paterno;
    @Column
    @NonNull
    private String materno;
    @Column 
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    @Column
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaContratacion;
    @Column
    @NonNull
    private Double salarioDiario;
    @Column
    @NonNull
    private Double salarioDiarioIntegrado;
    @Column
    private Long cuentaBanco;
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
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idTipoContrato")
    private c_TipoContratoEntity tipoContratoEntity;

    @ManyToOne
    @JoinColumn(name = "idTipoRegimen")
    private c_TipoRegimenEntity tipoRegimenEntity;

    @ManyToOne
    @JoinColumn(name = "idTipoJornada")
    private c_TipoJornadaEntity tipoJornadaEntity;

    @ManyToOne
    @JoinColumn(name = "idBanco")
    private c_BancoEntity bancoEntity;

    @ManyToOne
    @JoinColumn(name = "idRiesgoPuesto")
    private c_RiesgoPuestoEntity riesgoPuestoEntity;

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
