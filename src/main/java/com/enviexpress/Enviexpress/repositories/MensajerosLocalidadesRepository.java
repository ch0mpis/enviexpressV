package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.MensajerosLocalidades;
import com.enviexpress.Enviexpress.entities.MensajeroLocalidadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajerosLocalidadesRepository extends JpaRepository<MensajerosLocalidades, MensajeroLocalidadId> {
}