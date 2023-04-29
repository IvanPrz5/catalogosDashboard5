package com.example.catalogosDashboard.CatalogosCFDI.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="c_Aduana")
public class c_Aduana {
    @Id
    @NonNull
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String descripcion;
    @Column
    private Boolean status;
}