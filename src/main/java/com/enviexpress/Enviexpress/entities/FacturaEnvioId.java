package com.enviexpress.Enviexpress.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaEnvioId implements Serializable {
    private Integer factura;
    private Integer envio;

    public FacturaEnvioId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacturaEnvioId that = (FacturaEnvioId) o;
        return Objects.equals(factura, that.factura) && Objects.equals(envio, that.envio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factura, envio);
    }
}