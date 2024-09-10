package com.electrishop.detallespedidos.application;

import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;
import com.electrishop.detallespedidos.domain.service.DetallesPedidosService;

public class CreateDetallesPedidosUseCase {
    private DetallesPedidosService detallesPedidosService;

         // Constructor que recibe el servicio de detalles pedido
    public CreateDetallesPedidosUseCase(DetallesPedidosService detallesPedidosService) {
        this.detallesPedidosService = detallesPedidosService;
    }

        // Ejecuta la creación de un nuev detalles pedido
    public void execute(DetallesPedidos detallesPedidos) {
        detallesPedidosService.addDetallesPedidos(detallesPedidos);
    }
}
