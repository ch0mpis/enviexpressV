package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.UsuariosRoles;
import com.enviexpress.Enviexpress.entities.UsuarioRolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRolesRepository extends JpaRepository<UsuariosRoles, UsuarioRolId> {
}