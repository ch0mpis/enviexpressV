package com.enviexpress.Enviexpress.services;

import com.enviexpress.Enviexpress.entities.UsuariosRoles;
import com.enviexpress.Enviexpress.entities.UsuarioRolId;
import com.enviexpress.Enviexpress.repositories.UsuariosRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosRolesService {

    private final UsuariosRolesRepository usuariosRolesRepository;

    @Autowired
    public UsuariosRolesService(UsuariosRolesRepository usuariosRolesRepository) {
        this.usuariosRolesRepository = usuariosRolesRepository;
    }

    public List<UsuariosRoles> findAll() {
        return usuariosRolesRepository.findAll();
    }

    public UsuariosRoles findById(UsuarioRolId id) {
        return usuariosRolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación Usuario-Rol no encontrada."));
    }

    public UsuariosRoles save(UsuariosRoles usuariosRoles) {
        return usuariosRolesRepository.save(usuariosRoles);
    }

    public void deleteById(UsuarioRolId id) {
        usuariosRolesRepository.deleteById(id);
    }
}