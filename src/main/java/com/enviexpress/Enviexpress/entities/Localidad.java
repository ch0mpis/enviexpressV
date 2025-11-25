package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "localidades")
@Getter
@Setter
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localidad_id")
    private Integer id;

    @Column(name = "nombre_localidad", length = 100, nullable = false)
    private String nombre;

    @Column(name = "codigo_postal", length = 30)
    private String codigoPostal;

    @Column(name = "ciudad_id", nullable = false)
    private Integer ciudadId;

    @OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL)
    private List<MensajerosLocalidades> mensajerosLocalidades;
}