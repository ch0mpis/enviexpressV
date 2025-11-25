package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.RolesPermisos;
import com.enviexpress.Enviexpress.entities.RolPermisoId;
import com.enviexpress.Enviexpress.repositories.RolesPermisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolesPermisosService {

    private final RolesPermisosRepository rolesPermisosRepository;

    @Autowired
    public RolesPermisosService(RolesPermisosRepository rolesPermisosRepository) {
        this.rolesPermisosRepository = rolesPermisosRepository;
    }

    public List<RolesPermisos> findAll() {
        return rolesPermisosRepository.findAll();
    }

    public RolesPermisos findById(RolPermisoId id) {
        return rolesPermisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación Rol-Permiso no encontrada."));
    }

    public RolesPermisos save(RolesPermisos rolesPermisos) {
        // Lógica de asignación de permisos a roles
        return rolesPermisosRepository.save(rolesPermisos);
    }

    public void deleteById(RolPermisoId id) {
        rolesPermisosRepository.deleteById(id);
    }
}