package com.electrishop.pedido.domain.service;

import com.electrishop.pedido.domain.entity.Pedido;

public interface PedidoService {
    Pedido FindPedidoById(int id_pedido);
    void CreatePedido(Pedido pedido);
    void UpdatePedido(Pedido pedido);
    void DeletePedido(int id_pedido);
}
