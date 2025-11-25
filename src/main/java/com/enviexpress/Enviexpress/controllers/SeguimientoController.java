package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Seguimiento;
import com.enviexpress.Enviexpress.services.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seguimiento")
public class SeguimientoController {

    private final SeguimientoService seguimientoService;

    @Autowired
    public SeguimientoController(SeguimientoService seguimientoService) {
        this.seguimientoService = seguimientoService;
    }

    @GetMapping
    public List<Seguimiento> getAll() {
        return seguimientoService.findAll();
    }

    @GetMapping("/{id}")
    public Seguimiento getById(@PathVariable Integer id) {
        return seguimientoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Seguimiento> create(@RequestBody Seguimiento seguimiento) {
        Seguimiento savedSeguimiento = seguimientoService.save(seguimiento);
        return new ResponseEntity<>(savedSeguimiento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        seguimientoService.deleteById(id);
    }
}