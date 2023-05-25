package com.example.catalogosDashboard.Entity.Empleado;

import java.time.LocalDate;

import com.example.catalogosDashboard.Entity.CFDI.c_Periodicidad;
import com.example.catalogosDashboard.Entity.Nomina.c_OrigenRecursoEntity;
import com.example.catalogosDashboard.Entity.Nomina.c_TipoNominaEntity;
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
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Periodos")
public class PeriodosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nombre;
    @Column
    private Double diasPagados;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicio;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fin;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pago;
    @Column
    private String porcentajePropio;
    @Column
    private Boolean aguinaldo;
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idSubEmpresa")
    private SubEmpresasEntity idSubEmpresa;

    @ManyToOne
    @JoinColumn(name = "idPeriodicidad")
    private c_Periodicidad idPeriodicidad;

    @ManyToOne
    @JoinColumn(name = "idTipoNomina")
    private c_TipoNominaEntity idTipoNomina;
    
    @ManyToOne
    @JoinColumn(name = "idOrigenRecurso")
    private c_OrigenRecursoEntity idOrigenRecurso;
}
