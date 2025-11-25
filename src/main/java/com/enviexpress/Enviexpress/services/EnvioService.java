package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Envio;
import com.enviexpress.Enviexpress.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;
    // Debes inyectar ClienteRepository y TarifaRepository si usas el método create

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> findAll() {
        return envioRepository.findAll();
    }

    public Envio findById(Integer id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado con ID: " + id));
    }

    public Envio save(Envio envio) {
        // Lógica de negocio (ej. calcular costo, registrar seguimiento inicial)
        return envioRepository.save(envio);
    }

    public void deleteById(Integer id) {
        envioRepository.deleteById(id);
    }
}