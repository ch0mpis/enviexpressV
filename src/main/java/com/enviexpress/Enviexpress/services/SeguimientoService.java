package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Seguimiento;
import com.enviexpress.Enviexpress.repositories.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeguimientoService {

    private final SeguimientoRepository seguimientoRepository;
    // Puede necesitar inyectar EnvioService para actualizar el estado del envío

    @Autowired
    public SeguimientoService(SeguimientoRepository seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }

    public List<Seguimiento> findAll() {
        return seguimientoRepository.findAll();
    }

    public Seguimiento findById(Integer id) {
        return seguimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seguimiento no encontrado con ID: " + id));
    }

    public Seguimiento save(Seguimiento seguimiento) {
        // Lógica de registro (ej. actualizar estado en tabla Envio)
        return seguimientoRepository.save(seguimiento);
    }

    public void deleteById(Integer id) {
        seguimientoRepository.deleteById(id);
    }
}