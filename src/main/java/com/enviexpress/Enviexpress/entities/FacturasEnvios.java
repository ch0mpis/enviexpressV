package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "facturas_envios")
@Getter
@Setter
@IdClass(FacturaEnvioId.class)
public class FacturasEnvios implements Serializable {

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id")
    private Factura factura;

    @Id 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_id", referencedColumnName = "envio_id")
    private Envio envio;

    @Column(name = "orden_entrega", nullable = false)
    private Integer ordenEntrega;

    @Column(name = "iva_cobrado", precision = 12, scale = 2)
    private java.math.BigDecimal ivaCobrado;

    @Column(name = "total_cobrado", precision = 12, scale = 2)
    private java.math.BigDecimal totalCobrado;
}