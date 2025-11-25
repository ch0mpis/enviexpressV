package com.enviexpress.Enviexpress.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioRutaId implements Serializable {
    
    private Envio envio; // Mapea al campo 'envio' en EnvioRuta.java
    private Ruta ruta;   // Mapea al campo 'ruta' en EnvioRuta.java

    public EnvioRutaId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnvioRutaId that = (EnvioRutaId) o;
        return Objects.equals(envio, that.envio) && Objects.equals(ruta, that.ruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(envio, ruta);
    }
}