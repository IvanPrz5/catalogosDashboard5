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
@Table(name="c_RiesgoPuesto")
public class c_RiesgoPuestoEntity {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String descripcion;
    @Column
    private Boolean status;
}
