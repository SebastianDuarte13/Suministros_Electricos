package com.electrishop.detallescompra.domain.service;

import com.electrishop.detallescompra.domain.entity.DetallesCompra;

public interface DetallesCompraService {
    void addDetallesCompra(DetallesCompra detallesCompra);
    DetallesCompra findDetallesCompraById(int id_detalles_compra);
    void updateDetallesCompra(DetallesCompra detallesCompra);
    void deleteDetallesCompra(int id_detalles_compra);
}
