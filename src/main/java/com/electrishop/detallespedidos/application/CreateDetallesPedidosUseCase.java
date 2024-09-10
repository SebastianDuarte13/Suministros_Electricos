package com.electrishop.detallespedidos.application;

import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;
import com.electrishop.detallespedidos.domain.service.DetallesPedidosService;

public class CreateDetallesPedidosUseCase {
    private DetallesPedidosService detallesPedidosService;

    public CreateDetallesPedidosUseCase(DetallesPedidosService detallesPedidosService) {
        this.detallesPedidosService = detallesPedidosService;
    }

    public void execute(DetallesPedidos detallesPedidos) {
        detallesPedidosService.addDetallesPedidos(detallesPedidos);
    }
}
