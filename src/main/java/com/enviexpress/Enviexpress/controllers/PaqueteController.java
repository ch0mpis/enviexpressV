package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Paquete;
import com.enviexpress.Enviexpress.services.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public List<Paquete> getAll() {
        return paqueteService.findAll();
    }

    @GetMapping("/{id}")
    public Paquete getById(@PathVariable Integer id) {
        return paqueteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Paquete> create(@RequestBody Paquete paquete) {
        Paquete savedPaquete = paqueteService.save(paquete);
        return new ResponseEntity<>(savedPaquete, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        paqueteService.deleteById(id);
    }
}