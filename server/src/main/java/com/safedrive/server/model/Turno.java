package com.safedrive.server.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dniConductor;

    @Column(nullable = false)
    private String nombreConductor;

    @Column(nullable = false)
    private String unidad; //número de unidad o placa del vehículo

    private String ruta;

    @Column(nullable = false)
    private LocalDateTime horaInicio;

    private LocalDateTime horaFin;

    private String estado; // muestra el estado del turno: "EN RUTA", "FINALIZADO"

    public Turno() {
        this.horaInicio = LocalDateTime.now();
        this.estado = "EN_RUTA";
    }

    public Turno(String dniConductor, String nombreConductor, String unidad, String ruta) {
        this.dniConductor = dniConductor;
        this.nombreConductor = nombreConductor;
        this.unidad = unidad;
        this.ruta = ruta;
        this.horaInicio = LocalDateTime.now();
        this.estado = "EN_RUTA";
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getDniConductor() { return dniConductor; }
    public void setDniConductor(String dniConductor) { this.dniConductor = dniConductor; }
    public String getNombreConductor() { return nombreConductor; }
    public void setNombreConductor(String nombreConductor) { this.nombreConductor = nombreConductor; }
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }
    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }
    public LocalDateTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalDateTime horaInicio) { this.horaInicio = horaInicio; }
    public LocalDateTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalDateTime horaFin) { this.horaFin = horaFin; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}