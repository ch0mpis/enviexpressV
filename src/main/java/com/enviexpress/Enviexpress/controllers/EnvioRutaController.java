package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.EnvioRuta;
import com.enviexpress.Enviexpress.entities.EnvioRutaId;
import com.enviexpress.Enviexpress.services.EnvioRutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/envios-ruta")
public class EnvioRutaController {

    private final EnvioRutaService envioRutaService;

    @Autowired
    public EnvioRutaController(EnvioRutaService envioRutaService) {
        this.envioRutaService = envioRutaService;
    }

    @GetMapping
    public List<EnvioRuta> getAll() {
        return envioRutaService.findAll();
    }

    // Nota: El GET por ID compuesta es más complejo y generalmente se hace por POST o un DTO
    /*
    @GetMapping("/{envioId}/{rutaId}")
    public EnvioRuta getById(@PathVariable Integer envioId, @PathVariable Integer rutaId) {
        EnvioRutaId id = new EnvioRutaId();
        // Cargar Entidades Envio y Ruta aquí si EnvioRutaId usa Entidades
        return envioRutaService.findById(id);
    }
    */

    @PostMapping
    public ResponseEntity<EnvioRuta> create(@RequestBody EnvioRuta envioRuta) {
        EnvioRuta savedEnvioRuta = envioRutaService.save(envioRuta);
        return new ResponseEntity<>(savedEnvioRuta, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody EnvioRutaId id) {
        envioRutaService.deleteById(id);
    }
}