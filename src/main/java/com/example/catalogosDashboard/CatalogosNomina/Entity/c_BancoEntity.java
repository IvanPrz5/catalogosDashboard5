package com.example.catalogosDashboard.CatalogosNomina.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="c_Banco")
public class c_BancoEntity {
    @Id
    private String id;
    @Column
    private String descripcion;
    @Column
    private String razonSocial;
    @Column
    private Boolean status;
}

