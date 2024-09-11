package com.electrishop.pedidospendientes.domain.service;

import java.util.List;
import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;

public interface PedidosPendientesService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    List<PedidosPendientes> findAllPedidosPendientes();
}
