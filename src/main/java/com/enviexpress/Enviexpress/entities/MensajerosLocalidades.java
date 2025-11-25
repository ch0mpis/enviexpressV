package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajeros_localidades")
@Getter
@Setter
@IdClass(MensajeroLocalidadId.class)
public class MensajerosLocalidades implements Serializable {

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mensajero_id", referencedColumnName = "usuario_id")
    private Usuario mensajero;

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localidad_id", referencedColumnName = "localidad_id")
    private Localidad localidad;
    
    @Id
    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion; 
    
    @Column(name = "tipo_asignacion", length = 20)
    private String tipoAsignacion;
}