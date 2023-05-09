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
@Table(name="c_Forma_Pago")
public class c_FormaPago {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String descripcion;
    @Column
    private String bancarizado;
    @Column
    private String nombreBancoEmisorExtranjero;
    @Column
    private Boolean status;
}
