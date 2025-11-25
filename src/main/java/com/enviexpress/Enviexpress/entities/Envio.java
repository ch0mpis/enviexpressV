package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "envios")
@Getter
@Setter
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envio_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarifa_id", nullable = false)
    private Tarifa tarifa;
    
    @Column(name = "remitente_id", nullable = false)
    private Integer remitenteId;

    @Column(name = "nombre_destinatario", length = 255, nullable = false)
    private String nombreDestinatario;

    @Column(name = "direccion_destinatario", length = 255, nullable = false)
    private String direccionDestinatario;

    @Column(name = "telefono_destinatario", length = 50)
    private String telefonoDestinatario;

    @Column(name = "localidad_destino_id")
    private Integer localidadDestinoId;

    @Column(name = "ciudad_entrega_id")
    private Integer ciudadEntregaId;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_estimada_entrega")
    private LocalDateTime fechaEstimadaEntrega;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;
    
    @Column(name = "tipo_servicio", length = 50, nullable = false)
    private String tipoServicio;

    @Column(name = "costo_envio", precision = 10, scale = 2)
    private BigDecimal costoEnvio;

    @Column(name = "instrucciones_especiales", columnDefinition = "TEXT")
    private String instruccionesEspeciales;
    
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL)
    private List<EnvioRuta> enviosRutas;
    
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL)
    private List<Seguimiento> seguimientos;
    
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL)
    private List<Paquete> paquetes;
}