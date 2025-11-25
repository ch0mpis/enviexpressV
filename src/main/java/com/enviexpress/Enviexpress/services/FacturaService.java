package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Factura;
import com.enviexpress.Enviexpress.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Factura findById(Integer id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
    }

    public Factura save(Factura factura) {
        // Lógica de negocio (ej. calcular totales, asignar número de factura)
        return facturaRepository.save(factura);
    }

    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);
    }
}