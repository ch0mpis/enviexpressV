package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
}