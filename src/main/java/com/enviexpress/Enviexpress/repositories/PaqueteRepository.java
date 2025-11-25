package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
}