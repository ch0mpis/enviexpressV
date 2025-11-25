package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.UsuariosRoles;
import com.enviexpress.Enviexpress.entities.UsuarioRolId;
import com.enviexpress.Enviexpress.services.UsuariosRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios-roles")
public class UsuariosRolesController {

    private final UsuariosRolesService usuariosRolesService;

    @Autowired
    public UsuariosRolesController(UsuariosRolesService usuariosRolesService) {
        this.usuariosRolesService = usuariosRolesService;
    }

    @GetMapping
    public List<UsuariosRoles> getAll() {
        return usuariosRolesService.findAll();
    }

    @PostMapping
    public ResponseEntity<UsuariosRoles> create(@RequestBody UsuariosRoles usuariosRoles) {
        UsuariosRoles savedUsuariosRoles = usuariosRolesService.save(usuariosRoles);
        return new ResponseEntity<>(savedUsuariosRoles, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody UsuarioRolId id) {
        usuariosRolesService.deleteById(id);
    }
}