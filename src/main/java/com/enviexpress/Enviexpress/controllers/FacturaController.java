package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Factura;
import com.enviexpress.Enviexpress.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> getAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public Factura getById(@PathVariable Integer id) {
        return facturaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Factura> create(@RequestBody Factura factura) {
        Factura savedFactura = facturaService.save(factura);
        return new ResponseEntity<>(savedFactura, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Factura update(@PathVariable Integer id, @RequestBody Factura facturaDetails) {
        Factura factura = facturaService.findById(id);
        factura.setEstado(facturaDetails.getEstado());
        // Actualizar otros campos necesarios
        return facturaService.save(factura);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        facturaService.deleteById(id);
    }
}