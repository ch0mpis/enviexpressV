package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Getter
@Setter
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculo_id")
    private Integer id;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "placa", length = 30, unique = true, nullable = false)
    private String placa;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "capacidad_kg", precision = 8, scale = 2)
    private BigDecimal capacidadKg;

    @Column(name = "numero_chasis", length = 50)
    private String numeroChasis;

    @Column(name = "numero_motor", length = 50)
    private String numeroMotor;

    @Column(name = "empleado_asignado_id")
    private Integer empleadoAsignadoId;

    @Column(name = "estado", length = 50)
    private String estado;
    
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<MantenimientoVehiculo> mantenimientos;
}