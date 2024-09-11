package com.electrishop.pedido.domain.service;

import com.electrishop.pedido.domain.entity.Pedido;

public interface PedidoService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    Pedido FindPedidoById(int id_pedido);

    void CreatePedido(Pedido pedido);

    void UpdatePedido(Pedido pedido);

    void DeletePedido(int id_pedido);
}
