package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.MensajerosLocalidades;
import com.enviexpress.Enviexpress.entities.MensajeroLocalidadId;
import com.enviexpress.Enviexpress.repositories.MensajerosLocalidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MensajerosLocalidadesService {

    private final MensajerosLocalidadesRepository mensajerosLocalidadesRepository;

    @Autowired
    public MensajerosLocalidadesService(MensajerosLocalidadesRepository mensajerosLocalidadesRepository) {
        this.mensajerosLocalidadesRepository = mensajerosLocalidadesRepository;
    }

    public List<MensajerosLocalidades> findAll() {
        return mensajerosLocalidadesRepository.findAll();
    }

    public MensajerosLocalidades findById(MensajeroLocalidadId id) {
        return mensajerosLocalidadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación Mensajero-Localidad no encontrada."));
    }

    public MensajerosLocalidades save(MensajerosLocalidades mensajerosLocalidades) {
        // Lógica de asignación de mensajero a localidad
        return mensajerosLocalidadesRepository.save(mensajerosLocalidades);
    }

    public void deleteById(MensajeroLocalidadId id) {
        mensajerosLocalidadesRepository.deleteById(id);
    }
}