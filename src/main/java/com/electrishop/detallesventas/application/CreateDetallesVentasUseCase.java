package com.electrishop.detallesventas.application;

import com.electrishop.detallesventas.domain.entity.DetallesVentas;
import com.electrishop.detallesventas.domain.service.DetallesVentasService;

public class CreateDetallesVentasUseCase {
    private DetallesVentasService detallesVentasService;

         // Constructor que recibe el servicio de detalles ventas
    public CreateDetallesVentasUseCase(DetallesVentasService detallesVentasService) {
        this.detallesVentasService = detallesVentasService;
    }

        // Ejecuta la creación de un nuevo detalle venta
    public void execute(DetallesVentas detallesVentas) {
        detallesVentasService.addDetallesVentas(detallesVentas);
    }
}
