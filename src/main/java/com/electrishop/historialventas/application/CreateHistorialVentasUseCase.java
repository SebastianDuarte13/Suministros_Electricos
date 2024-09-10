package com.electrishop.historialventas.application;

import com.electrishop.historialventas.domain.entity.HistorialVentas;
import com.electrishop.historialventas.domain.service.HistorialVentasService;

public class CreateHistorialVentasUseCase {
    private final HistorialVentasService historialVentasService;

         // Constructor que recibe el servicio de Historial ventas
    public CreateHistorialVentasUseCase(HistorialVentasService historialVentasService) {
        this.historialVentasService = historialVentasService;
    }

        // Ejecuta la creación de un nuevo historial ventas
    public void execute(HistorialVentas historialVentas) {
        historialVentasService.FindAllHistorial();
    }
}
