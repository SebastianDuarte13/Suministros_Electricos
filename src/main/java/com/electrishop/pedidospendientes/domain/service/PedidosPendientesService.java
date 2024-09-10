package com.electrishop.pedidospendientes.domain.service;

import java.util.List;
import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;

public interface PedidosPendientesService {
    List<PedidosPendientes> findAllPedidosPendientes();
}
