package com.example.catalogosDashboard.CatalogosCFDI.Entity;

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
@Table(name="c_Tasa_Cuota")
public class c_TasaoCuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String rangoFijo;
    @Column
    private String valorMinimo;
    @Column
    private String valorMaximo;
    @Column
    private String impuesto;
    @Column
    private String factor;
    @Column
    private String traslado;
    @Column
    private String retencion;
    @Column
    private Boolean status;
}
   

