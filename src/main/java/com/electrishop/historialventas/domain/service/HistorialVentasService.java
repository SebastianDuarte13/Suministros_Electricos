package com.electrishop.historialventas.domain.service;

import com.electrishop.historialventas.domain.entity.HistorialVentas;
import java.util.List;

public interface HistorialVentasService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    List<HistorialVentas> FindAllHistorial();
}
