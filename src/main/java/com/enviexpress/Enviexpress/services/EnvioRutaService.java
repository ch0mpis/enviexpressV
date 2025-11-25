package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.EnvioRuta;
import com.enviexpress.Enviexpress.entities.EnvioRutaId;
import com.enviexpress.Enviexpress.repositories.EnviorutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioRutaService {

    private final EnviorutaRepository envioRutaRepository;
    // Puede necesitar inyectar EnvioRepository y RutaRepository para validar Ids

    @Autowired
    public EnvioRutaService(EnviorutaRepository envioRutaRepository) {
        this.envioRutaRepository = envioRutaRepository;
    }

    public List<EnvioRuta> findAll() {
        return envioRutaRepository.findAll();
    }

    public EnvioRuta findById(EnvioRutaId id) {
        return envioRutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación EnvioRuta no encontrada."));
    }

    public EnvioRuta save(EnvioRuta envioRuta) {
        // Lógica de asignación (ej. verificar orden de entrega, calcular hora estimada)
        return envioRutaRepository.save(envioRuta);
    }

    public void deleteById(EnvioRutaId id) {
        envioRutaRepository.deleteById(id);
    }
}