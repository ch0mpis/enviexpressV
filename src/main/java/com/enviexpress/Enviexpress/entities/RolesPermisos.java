package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "roles_permisos")
@Getter
@Setter
@IdClass(RolPermisoId.class)
public class RolesPermisos implements Serializable {

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    private Rol rol;

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permiso_id", referencedColumnName = "permiso_id")
    private Permiso permiso;
    
    @Column(name = "concedido", columnDefinition = "TINYINT(1)")
    private Boolean concedido;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
}