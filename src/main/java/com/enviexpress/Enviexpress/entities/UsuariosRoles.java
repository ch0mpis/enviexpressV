package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios_roles")
@Getter
@Setter
@IdClass(UsuarioRolId.class)
public class UsuariosRoles implements Serializable {

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    private Rol rol;

    @Column(name = "activo", columnDefinition = "TINYINT(1)")
    private Boolean activo;
    
    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
}