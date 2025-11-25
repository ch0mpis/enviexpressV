package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {
}