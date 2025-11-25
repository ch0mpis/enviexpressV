package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.FacturasEnvios;
import com.enviexpress.Enviexpress.entities.FacturaEnvioId;
import com.enviexpress.Enviexpress.services.FacturasEnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facturas-envios")
public class FacturaEnvioController {

    private final FacturasEnviosService facturasEnviosService;

    @Autowired
    public FacturaEnvioController(FacturasEnviosService facturasEnviosService) {
        this.facturasEnviosService = facturasEnviosService;
    }

    @GetMapping
    public List<FacturasEnvios> getAll() {
        return facturasEnviosService.findAll();
    }

    @PostMapping
    public ResponseEntity<FacturasEnvios> create(@RequestBody FacturasEnvios facturasEnvios) {
        FacturasEnvios savedFacturasEnvios = facturasEnviosService.save(facturasEnvios);
        return new ResponseEntity<>(savedFacturasEnvios, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody FacturaEnvioId id) {
        facturasEnviosService.deleteById(id);
    }
}