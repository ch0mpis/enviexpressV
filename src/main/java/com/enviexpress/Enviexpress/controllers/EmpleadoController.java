package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Empleado;
import com.enviexpress.Enviexpress.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.save(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Empleado update(@PathVariable Integer id, @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoService.findById(id);
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setEmail(empleadoDetails.getEmail());
        // Actualizar otros campos necesarios
        return empleadoService.save(empleado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        empleadoService.deleteById(id);
    }
}