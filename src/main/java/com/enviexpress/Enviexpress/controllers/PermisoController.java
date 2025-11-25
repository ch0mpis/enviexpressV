package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Permiso;
import com.enviexpress.Enviexpress.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoService permisoService;

    @Autowired
    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping
    public List<Permiso> getAll() {
        return permisoService.findAll();
    }

    @GetMapping("/{id}")
    public Permiso getById(@PathVariable Integer id) {
        return permisoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Permiso> create(@RequestBody Permiso permiso) {
        Permiso savedPermiso = permisoService.save(permiso);
        return new ResponseEntity<>(savedPermiso, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        permisoService.deleteById(id);
    }
}