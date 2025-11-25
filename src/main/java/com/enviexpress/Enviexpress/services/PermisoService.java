package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Permiso;
import com.enviexpress.Enviexpress.repositories.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermisoService {

    private final PermisoRepository permisoRepository;

    @Autowired
    public PermisoService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    public Permiso findById(Integer id) {
        return permisoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado con ID: " + id));
    }

    public Permiso save(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public void deleteById(Integer id) {
        permisoRepository.deleteById(id);
    }
}