package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.MensajerosLocalidades;
import com.enviexpress.Enviexpress.entities.MensajeroLocalidadId;
import com.enviexpress.Enviexpress.services.MensajerosLocalidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mensajeros-localidades")
public class MensajerosLocalidadesController {

    private final MensajerosLocalidadesService mensajerosLocalidadesService;

    @Autowired
    public MensajerosLocalidadesController(MensajerosLocalidadesService mensajerosLocalidadesService) {
        this.mensajerosLocalidadesService = mensajerosLocalidadesService;
    }

    @GetMapping
    public List<MensajerosLocalidades> getAll() {
        return mensajerosLocalidadesService.findAll();
    }

    @PostMapping
    public ResponseEntity<MensajerosLocalidades> create(@RequestBody MensajerosLocalidades asignacion) {
        MensajerosLocalidades savedAsignacion = mensajerosLocalidadesService.save(asignacion);
        return new ResponseEntity<>(savedAsignacion, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody MensajeroLocalidadId id) {
        mensajerosLocalidadesService.deleteById(id);
    }
}