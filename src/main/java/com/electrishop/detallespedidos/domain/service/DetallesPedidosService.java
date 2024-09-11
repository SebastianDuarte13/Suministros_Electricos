package com.electrishop.detallespedidos.domain.service;

import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;

public interface DetallesPedidosService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    void addDetallesPedidos(DetallesPedidos detallesPedidos);

    DetallesPedidos findDetallesPedidosById(int id_detalle_pedido);

    void updateDetallesPedidos(DetallesPedidos detallesPedidos);

    void deleteDetallesPedidos(int id_detalle_pedido);
}
