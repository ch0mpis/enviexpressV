package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.MantenimientoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoVehiculoRepository extends JpaRepository<MantenimientoVehiculo, Integer> {
}