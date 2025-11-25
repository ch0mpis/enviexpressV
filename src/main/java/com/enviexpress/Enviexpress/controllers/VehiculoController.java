package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Vehiculo;
import com.enviexpress.Enviexpress.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> getAll() {
        return vehiculoService.findAll();
    }

    @GetMapping("/{id}")
    public Vehiculo getById(@PathVariable Integer id) {
        return vehiculoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> create(@RequestBody Vehiculo vehiculo) {
        Vehiculo savedVehiculo = vehiculoService.save(vehiculo);
        return new ResponseEntity<>(savedVehiculo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        vehiculoService.deleteById(id);
    }
}