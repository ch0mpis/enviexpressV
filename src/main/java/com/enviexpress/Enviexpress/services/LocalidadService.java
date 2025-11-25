package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Localidad;
import com.enviexpress.Enviexpress.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalidadService {

    private final LocalidadRepository localidadRepository;

    @Autowired
    public LocalidadService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    public List<Localidad> findAll() {
        return localidadRepository.findAll();
    }

    public Localidad findById(Integer id) {
        return localidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localidad no encontrada con ID: " + id));
    }

    public Localidad save(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    public void deleteById(Integer id) {
        localidadRepository.deleteById(id);
    }
}