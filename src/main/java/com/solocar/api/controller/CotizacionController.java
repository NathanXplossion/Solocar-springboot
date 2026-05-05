package com.solocar.api.controller;

import com.solocar.api.model.Cotizacion;
import com.solocar.api.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestion de cotizaciones SOLOCAR S.A.S.
 * Expone endpoints CRUD para el modulo de cotizaciones.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionController {

    @Autowired
    private CotizacionService service;

    @GetMapping
    public List<Cotizacion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotizacion> buscar(@PathVariable int id) {
        Cotizacion cotizacion = service.buscarPorId(id);
        if (cotizacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cotizacion);
    }

    @PostMapping
    public ResponseEntity<Cotizacion> crear(@RequestBody Cotizacion cotizacion) {
        int filas = service.crear(cotizacion);
        if (filas > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(cotizacion);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cotizacion> actualizar(
            @PathVariable int id, 
            @RequestBody Cotizacion cotizacion) {
        cotizacion.setId(id);
        int filas = service.actualizar(cotizacion);
        if (filas > 0) {
            return ResponseEntity.ok(cotizacion);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        int filas = service.eliminar(id);
        if (filas > 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}