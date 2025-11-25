package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.MantenimientoVehiculo;
import com.enviexpress.Enviexpress.services.MantenimientoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoVehiculoController {

    private final MantenimientoVehiculoService mantenimientoVehiculoService;

    @Autowired
    public MantenimientoVehiculoController(MantenimientoVehiculoService mantenimientoVehiculoService) {
        this.mantenimientoVehiculoService = mantenimientoVehiculoService;
    }

    @GetMapping
    public List<MantenimientoVehiculo> getAll() {
        return mantenimientoVehiculoService.findAll();
    }

    @GetMapping("/{id}")
    public MantenimientoVehiculo getById(@PathVariable Integer id) {
        return mantenimientoVehiculoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<MantenimientoVehiculo> create(@RequestBody MantenimientoVehiculo mantenimiento) {
        MantenimientoVehiculo savedMantenimiento = mantenimientoVehiculoService.save(mantenimiento);
        return new ResponseEntity<>(savedMantenimiento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        mantenimientoVehiculoService.deleteById(id);
    }
}