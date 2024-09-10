package com.electrishop.detallesventas.application;

import com.electrishop.detallesventas.domain.entity.DetallesVentas;
import com.electrishop.detallesventas.domain.service.DetallesVentasService;

public class CreateDetallesVentasUseCase {
    private DetallesVentasService detallesVentasService;

    public CreateDetallesVentasUseCase(DetallesVentasService detallesVentasService) {
        this.detallesVentasService = detallesVentasService;
    }

    public void execute(DetallesVentas detallesVentas) {
        detallesVentasService.addDetallesVentas(detallesVentas);
    }
}
