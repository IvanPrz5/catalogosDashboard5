package com.example.catalogosDashboard.Entity.CFDI;

import java.util.List;

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
@Table(name="c_Localidad")
public class c_Localidad {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String cod;
    @Column
    private String descripcion;
    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="idEstado")
    private c_Estado estado;

    /* @OneToMany(mappedBy = "cCodigoPostal")
    private List<c_CodigoPostal> codigos; */
}
