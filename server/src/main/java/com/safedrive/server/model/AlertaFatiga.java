package com.safedrive.server.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas_fatiga")
public class AlertaFatiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String unidad; // Ej: "302-A"

    @Column(nullable = false)
    private String conductor; // Ej: "J. Pérez Gómez"

    @Column(nullable = false)
    private String tipoAlerta; // Ej: "Microsueño"

    private Double earCalculado; // Valor del EAR al disparar

    private LocalDateTime fechaHora;

    public AlertaFatiga() {
        this.fechaHora = LocalDateTime.now();
    }

    public AlertaFatiga(String unidad, String conductor, String tipoAlerta, Double earCalculado) {
        this.unidad = unidad;
        this.conductor = conductor;
        this.tipoAlerta = tipoAlerta;
        this.earCalculado = earCalculado;
        this.fechaHora = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }
    public String getConductor() { return conductor; }
    public void setConductor(String conductor) { this.conductor = conductor; }
    public String getTipoAlerta() { return tipoAlerta; }
    public void setTipoAlerta(String tipoAlerta) { this.tipoAlerta = tipoAlerta; }
    public Double getEarCalculado() { return earCalculado; }
    public void setEarCalculado(Double earCalculado) { this.earCalculado = earCalculado; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}