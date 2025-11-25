package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {
}