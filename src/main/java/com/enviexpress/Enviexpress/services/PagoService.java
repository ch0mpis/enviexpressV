package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Pago;
import com.enviexpress.Enviexpress.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;
    // Puede necesitar inyectar FacturaRepository

    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago findById(Integer id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + id));
    }

    public Pago save(Pago pago) {
        // Lógica de validación de pago, actualizar estado de Factura
        return pagoRepository.save(pago);
    }

    public void deleteById(Integer id) {
        pagoRepository.deleteById(id);
    }
}