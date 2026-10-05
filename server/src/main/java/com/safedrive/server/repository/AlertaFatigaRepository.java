package com.safedrive.server.repository;

import com.safedrive.server.model.AlertaFatiga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertaFatigaRepository extends JpaRepository<AlertaFatiga, Long> {
    // Método para obtener alertas por unidad (ej. "302-A")
    List<AlertaFatiga> findByUnidadOrderByFechaHoraDesc(String unidad);
}