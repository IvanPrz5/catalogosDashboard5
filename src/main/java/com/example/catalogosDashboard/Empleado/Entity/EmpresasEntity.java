package com.example.catalogosDashboard.Empleado.Entity;

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
@Table(name = "Empresas")
public class EmpresasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String nombre;
    @Column(length = 4)
    private String satRegimen;
    @Column(length = 8)
    private String cp;
    @Column
    private String cerB64;
    @Column
    private String keyB64;
    @Column
    private String numCertificado;
    @Column
    private String usuarioPac;
    @Column 
    private String contraseñaPac;
    @Column
    private String fisica;
    @Column 
    private String curp;
    @Column
    private Boolean status;
    
}
