package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.HorarioTrabajo;
import com.enviexpress.Enviexpress.services.HorarioTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioTrabajoController {

    private final HorarioTrabajoService horarioTrabajoService;

    @Autowired
    public HorarioTrabajoController(HorarioTrabajoService horarioTrabajoService) {
        this.horarioTrabajoService = horarioTrabajoService;
    }

    @GetMapping
    public List<HorarioTrabajo> getAll() {
        return horarioTrabajoService.findAll();
    }

    @GetMapping("/{id}")
    public HorarioTrabajo getById(@PathVariable Integer id) {
        return horarioTrabajoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<HorarioTrabajo> create(@RequestBody HorarioTrabajo horario) {
        HorarioTrabajo savedHorario = horarioTrabajoService.save(horario);
        return new ResponseEntity<>(savedHorario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        horarioTrabajoService.deleteById(id);
    }
}