package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}