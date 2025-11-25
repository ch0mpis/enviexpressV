package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empleados")
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "tipo_documento", length = 50, nullable = false)
    private String tipoDocumento;

    @Column(name = "documento_identidad", length = 35, unique = true, nullable = false)
    private String documentoIdentidad;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "localidad_asignada_id")
    private Integer localidadAsignadaId;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "tipo_contrato_id")
    private Integer tipoContratoId;

    @Column(name = "salario", precision = 10, scale = 2)
    private java.math.BigDecimal salario;

    @Column(name = "activo", columnDefinition = "TINYINT(1)")
    private Boolean activo;

    @OneToMany(mappedBy = "mensajero", cascade = CascadeType.ALL)
    private List<Ruta> rutas;

    @OneToMany(mappedBy = "empleadoResponsable", cascade = CascadeType.ALL)
    private List<Seguimiento> seguimientos;
}