package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.MantenimientoVehiculo;
import com.enviexpress.Enviexpress.repositories.MantenimientoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MantenimientoVehiculoService {

    private final MantenimientoVehiculoRepository mantenimientoVehiculoRepository;
    // Puede necesitar inyectar VehiculoRepository para validar

    @Autowired
    public MantenimientoVehiculoService(MantenimientoVehiculoRepository mantenimientoVehiculoRepository) {
        this.mantenimientoVehiculoRepository = mantenimientoVehiculoRepository;
    }

    public List<MantenimientoVehiculo> findAll() {
        return mantenimientoVehiculoRepository.findAll();
    }

    public MantenimientoVehiculo findById(Integer id) {
        return mantenimientoVehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));
    }

    public MantenimientoVehiculo save(MantenimientoVehiculo mantenimientoVehiculo) {
        return mantenimientoVehiculoRepository.save(mantenimientoVehiculo);
    }

    public void deleteById(Integer id) {
        mantenimientoVehiculoRepository.deleteById(id);
    }
}