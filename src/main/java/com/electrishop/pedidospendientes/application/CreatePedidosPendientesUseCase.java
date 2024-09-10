package com.electrishop.pedidospendientes.application;

import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;
import com.electrishop.pedidospendientes.domain.service.PedidosPendientesService;

public class CreatePedidosPendientesUseCase {
    private final PedidosPendientesService pedidosPendientesService;
         // Constructor que recibe el servicio de pedidos pendientes
    public CreatePedidosPendientesUseCase(PedidosPendientesService pedidosPendientesService) {
        this.pedidosPendientesService = pedidosPendientesService;
    }

        // Ejecuta la creación de un nuevo  pedidopendientes
    public void execute(PedidosPendientes pedidosPendientes) {
        pedidosPendientesService.findAllPedidosPendientes();
    }
}
