package com.electrishop.ventas.application;

import com.electrishop.ventas.domain.entity.Venta;
import com.electrishop.ventas.domain.service.VentaService;

public class CreateVentaUseCase {
    private final VentaService ventaService;

    public CreateVentaUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public void execute(Venta venta) {
        ventaService.createVenta(venta);
    }
}
