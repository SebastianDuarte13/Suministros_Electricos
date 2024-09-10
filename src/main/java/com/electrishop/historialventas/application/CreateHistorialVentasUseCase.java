package com.electrishop.historialventas.application;

import com.electrishop.historialventas.domain.entity.HistorialVentas;
import com.electrishop.historialventas.domain.service.HistorialVentasService;

public class CreateHistorialVentasUseCase {
    private final HistorialVentasService historialVentasService;

    public CreateHistorialVentasUseCase(HistorialVentasService historialVentasService) {
        this.historialVentasService = historialVentasService;
    }

    public void execute(HistorialVentas historialVentas) {
        historialVentasService.FindAllHistorial();
    }
}
