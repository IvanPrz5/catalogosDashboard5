package com.example.catalogosDashboard.CatalogosCFDI.Entity;

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
@Table(name="c_Estado")
public class c_Estado {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String nombreEstado;
    @Column
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="idPais")
    private c_Pais pais;

    /* @OneToMany(mappedBy = "cLocalidad")
    private List<c_Localidad> localidades;

    @OneToMany(mappedBy = "cMunicipio")
    private List<c_Municipio> municipios;

    @OneToMany(mappedBy = "cCodigoPostal")
    private List<c_CodigoPostal> codigos; */
}