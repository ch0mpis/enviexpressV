package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Tarifa;
import com.enviexpress.Enviexpress.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    private final TarifaService tarifaService;

    @Autowired
    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @GetMapping
    public List<Tarifa> getAll() {
        return tarifaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarifa getById(@PathVariable Integer id) {
        return tarifaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Tarifa> create(@RequestBody Tarifa tarifa) {
        Tarifa savedTarifa = tarifaService.save(tarifa);
        return new ResponseEntity<>(savedTarifa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        tarifaService.deleteById(id);
    }
}