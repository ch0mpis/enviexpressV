package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Integer id;

    @Column(name = "nombre_rol", length = 100, nullable = false)
    private String nombre;

    @Column(name = "nivel_acceso", nullable = false)
    private Integer nivelAcceso;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UsuariosRoles> usuariosRoles;
    
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<RolesPermisos> rolesPermisos;
}