package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name = "username", length = 20, unique = true, nullable = false)
    private String username;

    @Column(name = "nombre_usuario", length = 255, nullable = false)
    private String nombreUsuario;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "rol_principal_id")
    private Integer rolPrincipalId;

    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    @Column(name = "activo", columnDefinition = "TINYINT(1)")
    private Boolean activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuariosRoles> usuariosRoles;
    
    @OneToMany(mappedBy = "mensajero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MensajerosLocalidades> mensajerosLocalidades;
}