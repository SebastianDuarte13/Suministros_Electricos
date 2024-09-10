package com.electrishop.pedido.application;

import com.electrishop.pedido.domain.entity.Pedido;
import com.electrishop.pedido.domain.service.PedidoService;

public class CreatePedidoUseCase {
    private final PedidoService pedidoService;
    
         // Constructor que recibe el servicio de detalles pedido
    public CreatePedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
        // Ejecuta la creación de un nuev detalles pedido
    public void execute(Pedido pedido) {
        pedidoService.CreatePedido(pedido);
    }
}
