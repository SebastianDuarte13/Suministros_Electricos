package com.electrishop.factura.domain.service;

import com.electrishop.factura.domain.entity.Factura;

public interface FacturaService {
    Factura FindFacturaById(int id_detalle_venta);
}
