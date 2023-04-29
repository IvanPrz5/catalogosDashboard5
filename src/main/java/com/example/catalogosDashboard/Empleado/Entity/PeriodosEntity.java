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
    private Long satPeriodicidad;
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
    private String satTipoNomina;
    @Column
    private String satOrigenRecurso;
    @Column
    private String porcentajePropio;
    @Column
    private Boolean aguinaldo;
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idSubEmpresa")
    private SubEmpresasEntity subEmpresasEntity;
}
