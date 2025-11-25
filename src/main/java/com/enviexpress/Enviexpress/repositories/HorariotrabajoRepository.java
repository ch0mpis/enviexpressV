package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.HorarioTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariotrabajoRepository extends JpaRepository<HorarioTrabajo, Integer> {
}