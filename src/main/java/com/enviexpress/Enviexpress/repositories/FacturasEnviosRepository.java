package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.FacturasEnvios;
import com.enviexpress.Enviexpress.entities.FacturaEnvioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturasEnviosRepository extends JpaRepository<FacturasEnvios, FacturaEnvioId> {
}