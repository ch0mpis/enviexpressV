package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.Vehiculo;
import com.enviexpress.Enviexpress.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo findById(Integer id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }

    public Vehiculo save(Vehiculo vehiculo) {
        // Lógica de validación (ej. placa única, capacidad)
        return vehiculoRepository.save(vehiculo);
    }

    public void deleteById(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}