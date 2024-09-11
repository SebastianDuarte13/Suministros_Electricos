package com.electrishop.factura.domain.service;

import com.electrishop.factura.domain.entity.Factura;

public interface FacturaService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    Factura FindFacturaById(int id_detalle_venta);
}
