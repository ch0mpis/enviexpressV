package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mantenimientos_vehiculos")
@Getter
@Setter
public class MantenimientoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mantenimiento_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "tipo_mantenimiento", length = 50, nullable = false)
    private String tipoMantenimiento;

    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDateTime fechaMantenimiento;

    @Column(name = "kilometraje_actual")
    private Integer kilometrajeActual;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "empleado_responsable_id")
    private Integer empleadoResponsableId;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;
}