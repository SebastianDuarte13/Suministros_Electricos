package com.electrishop.ventas.domain.service;

import com.electrishop.ventas.domain.entity.Venta;

public interface VentaService {
    Venta findVentaById(int id_venta);
    void createVenta(Venta venta);
    void updateVenta(Venta venta);
    void deleteVenta(int id_venta);
}
