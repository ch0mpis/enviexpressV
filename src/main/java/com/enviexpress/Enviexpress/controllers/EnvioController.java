package com.enviexpress.Enviexpress.controllers;

import com.enviexpress.Enviexpress.entities.Envio;
import com.enviexpress.Enviexpress.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio> getAll() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public Envio getById(@PathVariable Integer id) {
        return envioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Envio> create(@RequestBody Envio envio) {
        Envio savedEnvio = envioService.save(envio);
        return new ResponseEntity<>(savedEnvio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Envio update(@PathVariable Integer id, @RequestBody Envio envioDetails) {
        Envio envio = envioService.findById(id);
        envio.setEstado(envioDetails.getEstado());
        // Actualizar otros campos necesarios
        return envioService.save(envio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        envioService.deleteById(id);
    }
}