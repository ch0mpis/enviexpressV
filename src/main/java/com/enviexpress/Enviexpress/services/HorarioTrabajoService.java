package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.HorarioTrabajo;
import com.enviexpress.Enviexpress.repositories.HorariotrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioTrabajoService {

    private final HorariotrabajoRepository horarioTrabajoRepository;

    @Autowired
    public HorarioTrabajoService(HorariotrabajoRepository horarioTrabajoRepository) {
        this.horarioTrabajoRepository = horarioTrabajoRepository;
    }

    public List<HorarioTrabajo> findAll() {
        return horarioTrabajoRepository.findAll();
    }

    public HorarioTrabajo findById(Integer id) {
        return horarioTrabajoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario de Trabajo no encontrado con ID: " + id));
    }

    public HorarioTrabajo save(HorarioTrabajo horarioTrabajo) {
        return horarioTrabajoRepository.save(horarioTrabajo);
    }

    public void deleteById(Integer id) {
        horarioTrabajoRepository.deleteById(id);
    }
}