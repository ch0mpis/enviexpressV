package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.RolesPermisos;
import com.enviexpress.Enviexpress.entities.RolPermisoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPermisosRepository extends JpaRepository<RolesPermisos, RolPermisoId> {
}