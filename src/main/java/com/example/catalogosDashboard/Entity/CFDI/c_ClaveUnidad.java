package com.example.catalogosDashboard.Entity.CFDI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="c_Clave_Unidad")
public class c_ClaveUnidad {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String nombre;
    @Column(length = 600)
    private String descripcion;
    @Column
    private String simbolo;
    @Column
    private Boolean status;
}
