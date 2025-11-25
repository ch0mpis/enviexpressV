package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "permisos")
@Getter
@Setter
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permiso_id")
    private Integer id;

    @Column(name = "nombre_modulo", length = 100, nullable = false)
    private String nombreModulo;

    @Column(name = "nombre_permiso", length = 100, nullable = false)
    private String nombrePermiso;
    
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "endpoint", length = 255)
    private String endpoint;

    @Column(name = "activo", columnDefinition = "TINYINT(1)")
    private Boolean activo;

    @OneToMany(mappedBy = "permiso", cascade = CascadeType.ALL)
    private List<RolesPermisos> rolesPermisos;
}