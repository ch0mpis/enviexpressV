package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios_ruta")
@Getter
@Setter
@IdClass(EnvioRutaId.class)
public class EnvioRuta implements Serializable {

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_id", referencedColumnName = "envio_id")
    private Envio envio;

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruta_id", referencedColumnName = "ruta_id")
    private Ruta ruta;
    
    @Column(name = "orden_entrega", nullable = false)
    private Integer ordenEntrega;

    @Column(name = "hora_estimada_entrega")
    private LocalDateTime horaEstimadaEntrega;

    @Column(name = "hora_real_entrega")
    private LocalDateTime horaRealEntrega;
}