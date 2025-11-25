package com.enviexpress.Enviexpress.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer id;

    @Column(name = "tipo_documento", length = 50, nullable = false)
    private String tipoDocumento;

    @Column(name = "documento_identidad", length = 35, unique = true, nullable = false)
    private String documentoIdentidad;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "telefono", length = 50, nullable = false)
    private String telefono;

    @Column(name = "ciudad_id", nullable = false)
    private Integer ciudadId;

    @Column(name = "localidad_id", nullable = false)
    private Integer localidadId;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Envio> envios;
}