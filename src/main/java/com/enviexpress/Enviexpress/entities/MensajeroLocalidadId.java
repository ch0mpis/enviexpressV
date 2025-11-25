package com.enviexpress.Enviexpress.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MensajeroLocalidadId implements Serializable {
    private Integer mensajero;
    private Integer localidad;
    private LocalDateTime fechaAsignacion; 

    public MensajeroLocalidadId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensajeroLocalidadId that = (MensajeroLocalidadId) o;
        return Objects.equals(mensajero, that.mensajero) && Objects.equals(localidad, that.localidad) && Objects.equals(fechaAsignacion, that.fechaAsignacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensajero, localidad, fechaAsignacion);
    }
}