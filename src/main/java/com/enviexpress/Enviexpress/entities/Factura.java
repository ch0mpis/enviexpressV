package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Integer id;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "numero_factura", length = 20, unique = true, nullable = false)
    private String numeroFactura;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "fecha_vencimiento")
    private LocalDateTime fechaVencimiento;

    @Column(name = "subtotal_decimal", precision = 12, scale = 2)
    private BigDecimal subtotalDecimal;

    @Column(name = "iva_decimal", precision = 12, scale = 2)
    private BigDecimal ivaDecimal;

    @Column(name = "descuento_decimal", precision = 12, scale = 2)
    private BigDecimal descuentoDecimal;

    @Column(name = "total_decimal", precision = 12, scale = 2)
    private BigDecimal totalDecimal;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "empleado_generador_id")
    private Integer empleadoGeneradorId;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturasEnvios> facturasEnvios;
    
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Pago> pagos;
}