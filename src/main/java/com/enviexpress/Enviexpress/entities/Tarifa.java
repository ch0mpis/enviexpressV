package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tarifas")
@Getter
@Setter
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarifa_id")
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "tipo_servicio_id")
    private Integer tipoServicioId;

    @Column(name = "localidad_origen_id")
    private Integer localidadOrigenId;

    @Column(name = "localidad_destino_id")
    private Integer localidadDestinoId;

    @Column(name = "rango_peso_min", precision = 8, scale = 2)
    private BigDecimal rangoPesoMin;

    @Column(name = "rango_peso_max", precision = 8, scale = 2)
    private BigDecimal rangoPesoMax;

    @Column(name = "precio_base", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioBase;

    @Column(name = "porcentaje_adicional", precision = 8, scale = 2)
    private BigDecimal porcentajeAdicional;

    @Column(name = "vigencia_desde")
    private LocalDate vigenciaDesde;

    @Column(name = "vigencia_hasta")
    private LocalDate vigenciaHasta;

    @OneToMany(mappedBy = "tarifa", cascade = CascadeType.ALL)
    private List<Envio> envios;
}