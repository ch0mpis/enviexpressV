package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Localidad;
import com.enviexpress.Enviexpress.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadController {

    private final LocalidadService localidadService;

    @Autowired
    public LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping
    public List<Localidad> getAll() {
        return localidadService.findAll();
    }

    @GetMapping("/{id}")
    public Localidad getById(@PathVariable Integer id) {
        return localidadService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Localidad> create(@RequestBody Localidad localidad) {
        Localidad savedLocalidad = localidadService.save(localidad);
        return new ResponseEntity<>(savedLocalidad, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        localidadService.deleteById(id);
    }
}