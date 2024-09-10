package com.electrishop.pedidospendientes.application;

import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;
import com.electrishop.pedidospendientes.domain.service.PedidosPendientesService;

public class CreatePedidosPendientesUseCase {
    private final PedidosPendientesService pedidosPendientesService;

    public CreatePedidosPendientesUseCase(PedidosPendientesService pedidosPendientesService) {
        this.pedidosPendientesService = pedidosPendientesService;
    }

    public void execute(PedidosPendientes pedidosPendientes) {
        pedidosPendientesService.findAllPedidosPendientes();
    }
}
