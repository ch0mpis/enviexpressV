package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Tarifa;
import com.enviexpress.Enviexpress.repositories.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarifaService {

    private final TarifaRepository tarifaRepository;

    @Autowired
    public TarifaService(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    public List<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }

    public Tarifa findById(Integer id) {
        return tarifaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada con ID: " + id));
    }

    public Tarifa save(Tarifa tarifa) {
        // Lógica de validación de vigencia y rangos
        return tarifaRepository.save(tarifa);
    }

    public void deleteById(Integer id) {
        tarifaRepository.deleteById(id);
    }
}