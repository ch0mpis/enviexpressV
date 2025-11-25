package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.RolesPermisos;
import com.enviexpress.Enviexpress.entities.RolPermisoId;
import com.enviexpress.Enviexpress.services.RolesPermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles-permisos")
public class RolesPermisosController {

    private final RolesPermisosService rolesPermisosService;

    @Autowired
    public RolesPermisosController(RolesPermisosService rolesPermisosService) {
        this.rolesPermisosService = rolesPermisosService;
    }

    @GetMapping
    public List<RolesPermisos> getAll() {
        return rolesPermisosService.findAll();
    }

    @PostMapping
    public ResponseEntity<RolesPermisos> create(@RequestBody RolesPermisos rolesPermisos) {
        RolesPermisos savedRolesPermisos = rolesPermisosService.save(rolesPermisos);
        return new ResponseEntity<>(savedRolesPermisos, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody RolPermisoId id) {
        rolesPermisosService.deleteById(id);
    }
}