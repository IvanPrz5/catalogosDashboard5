package com.example.catalogosDashboard.Entity.CFDI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "c_Pais")
public class c_Pais {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String descripcion;
    @Column
    private Boolean status;

    /* @OneToMany(mappedBy = "cEstado")
    private List<c_Estado> estados; */
}
