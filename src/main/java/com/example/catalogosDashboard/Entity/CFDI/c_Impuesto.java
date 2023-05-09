package com.example.catalogosDashboard.Entity.CFDI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="c_Impuesto")
public class c_Impuesto {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column
    private String descripcion;
    @Column
    private String retencion;
    @Column
    private String traslado;
    @Column
    private String localFederal;
    @Column
    private Boolean status;
}   
