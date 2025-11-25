package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.FacturasEnvios;
import com.enviexpress.Enviexpress.entities.FacturaEnvioId;
import com.enviexpress.Enviexpress.repositories.FacturasEnviosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturasEnviosService {

    private final FacturasEnviosRepository facturasEnviosRepository;

    @Autowired
    public FacturasEnviosService(FacturasEnviosRepository facturasEnviosRepository) {
        this.facturasEnviosRepository = facturasEnviosRepository;
    }

    public List<FacturasEnvios> findAll() {
        return facturasEnviosRepository.findAll();
    }

    public FacturasEnvios findById(FacturaEnvioId id) {
        return facturasEnviosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asociación Factura-Envío no encontrada."));
    }

    public FacturasEnvios save(FacturasEnvios facturasEnvios) {
        // Lógica de asociación y cálculo de costos por envío
        return facturasEnviosRepository.save(facturasEnvios);
    }

    public void deleteById(FacturaEnvioId id) {
        facturasEnviosRepository.deleteById(id);
    }
}