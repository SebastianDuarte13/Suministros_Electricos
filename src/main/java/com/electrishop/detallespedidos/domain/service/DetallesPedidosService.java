package com.electrishop.detallespedidos.domain.service;

import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;

public interface DetallesPedidosService {
    void addDetallesPedidos(DetallesPedidos detallesPedidos);
    DetallesPedidos findDetallesPedidosById(int id_detalle_pedido);
    void updateDetallesPedidos(DetallesPedidos detallesPedidos);
    void deleteDetallesPedidos(int id_detalle_pedido);
}
