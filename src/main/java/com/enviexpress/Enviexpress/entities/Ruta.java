package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rutas")
@Getter
@Setter
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ruta_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado mensajero;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id", nullable = false)
    private HorarioTrabajo horario;

    @Column(name = "fecha_ruta", nullable = false)
    private LocalDateTime fechaRuta;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "hora_inicio_real")
    private LocalDateTime horaInicioReal;

    @Column(name = "hora_fin_real")
    private LocalDateTime horaFinReal;
    
    @Column(name = "total_envios")
    private Integer totalEnvios;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<EnvioRuta> enviosRutas;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Localidad> localidades;
}