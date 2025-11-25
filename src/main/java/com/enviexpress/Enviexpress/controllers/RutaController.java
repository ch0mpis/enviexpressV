package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Ruta;
import com.enviexpress.Enviexpress.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    private final RutaService rutaService;

    @Autowired
    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public List<Ruta> getAll() {
        return rutaService.findAll();
    }

    @GetMapping("/{id}")
    public Ruta getById(@PathVariable Integer id) {
        return rutaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Ruta> create(@RequestBody Ruta ruta) {
        Ruta savedRuta = rutaService.save(ruta);
        return new ResponseEntity<>(savedRuta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        rutaService.deleteById(id);
    }
}