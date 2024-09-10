package com.electrishop.ventas.application;

import com.electrishop.ventas.domain.entity.Venta;
import com.electrishop.ventas.domain.service.VentaService;

public class CreateVentaUseCase {
    private final VentaService ventaService;

             // Constructor que recibe el servicio de venta
    public CreateVentaUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

            // Ejecuta la creación de una nueva venta
    public void execute(Venta venta) {
        ventaService.createVenta(venta);
    }
}
