package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}