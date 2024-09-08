package com.electrishop.pedido.application;

import com.electrishop.pedido.domain.entity.Pedido;
import com.electrishop.pedido.domain.service.PedidoService;

public class CreatePedidoUseCase {
    private final PedidoService pedidoService;

    public CreatePedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void execute(Pedido pedido) {
        pedidoService.CreatePedido(pedido);
    }
}
