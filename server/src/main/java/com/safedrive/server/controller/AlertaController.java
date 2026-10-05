package com.safedrive.server.controller;

import com.safedrive.server.model.AlertaFatiga;
import com.safedrive.server.repository.AlertaFatigaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*") // Permite peticiones desde el Live Server (http://127.0.0.1:5500)
public class AlertaController {

    private final AlertaFatigaRepository alertaRepository;

    public AlertaController(AlertaFatigaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    // Endpoint POST: Recibe la alerta de la cámara en vivo
    @PostMapping
    public ResponseEntity<AlertaFatiga> registrarAlerta(@RequestBody AlertaFatiga alerta) {
        AlertaFatiga guardada = alertaRepository.save(alerta);
        System.out.println("🚨 [ALERTA GUARDADA]: Unidad " + guardada.getUnidad() + " - Conductor: " + guardada.getConductor());
        return ResponseEntity.ok(guardada);
    }

    // Endpoint GET: Obtener todas las alertas para el Dashboard del Supervisor
    @GetMapping
    public ResponseEntity<List<AlertaFatiga>> listarAlertas() {
        return ResponseEntity.ok(alertaRepository.findAll());
    }
}