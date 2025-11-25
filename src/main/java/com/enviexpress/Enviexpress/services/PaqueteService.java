package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Paquete;
import com.enviexpress.Enviexpress.repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;
    // Puede necesitar inyectar EnvioRepository

    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public List<Paquete> findAll() {
        return paqueteRepository.findAll();
    }

    public Paquete findById(Integer id) {
        return paqueteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado con ID: " + id));
    }

    public Paquete save(Paquete paquete) {
        // Lógica de cálculo de dimensiones/peso total del envío
        return paqueteRepository.save(paquete);
    }

    public void deleteById(Integer id) {
        paqueteRepository.deleteById(id);
    }
}