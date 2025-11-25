package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Ruta;
import com.enviexpress.Enviexpress.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RutaService {

    private final RutaRepository rutaRepository;
    // Puede necesitar inyectar EmpleadoRepository y HorarioTrabajoRepository

    @Autowired
    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    public Ruta findById(Integer id) {
        return rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada con ID: " + id));
    }

    public Ruta save(Ruta ruta) {
        // Lógica de planificación de rutas (ej. calcular total de envíos, asignar horarios)
        return rutaRepository.save(ruta);
    }

    public void deleteById(Integer id) {
        rutaRepository.deleteById(id);
    }
}